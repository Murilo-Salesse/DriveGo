package br.com.DriveGo.drivego.infrastructure.stripe;

import br.com.DriveGo.drivego.core.enums.PaymentStatus;
import br.com.DriveGo.drivego.core.gateways.PaymentGateway;
import br.com.DriveGo.drivego.core.gateways.ReservationGateway;
import br.com.DriveGo.drivego.core.usecases.stripe.HandleStripeWebhookUseCase;
import com.stripe.exception.SignatureVerificationException;
import com.stripe.model.Event;
import com.stripe.model.PaymentIntent;
import com.stripe.net.Webhook;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HandleStripeWebhookUseCaseImp
        implements HandleStripeWebhookUseCase {

    @Value("${stripe.api.key}")
    private String webhookSecret;

    private final PaymentGateway paymentGateway;
    private final ReservationGateway reservationGateway;

    public HandleStripeWebhookUseCaseImp(
            PaymentGateway paymentGateway,
            ReservationGateway reservationGateway
    ) {
        this.paymentGateway = paymentGateway;
        this.reservationGateway = reservationGateway;
    }

    @Override
    @Transactional
    public void execute(String payload, String signature) {

        Event event = verifySignature(payload, signature);

        switch (event.getType()) {

            case "payment_intent.succeeded" ->
                    handleSucceeded(event);

            case "payment_intent.payment_failed" ->
                    handleFailed(event);

            default -> {
                // eventos ignorados
            }
        }
    }

    private Event verifySignature(
            String payload,
            String signature
    ) {
        try {
            return Webhook.constructEvent(
                    payload,
                    signature,
                    webhookSecret
            );
        } catch (SignatureVerificationException e) {
            throw new SecurityException("Webhook Stripe inválido");
        }
    }

    private void handleSucceeded(Event event) {

        PaymentIntent intent =
                (PaymentIntent) event
                        .getDataObjectDeserializer()
                        .getObject()
                        .orElseThrow();

        String providerReference = intent.getId();

        var payment =
                paymentGateway.findByProviderReference(providerReference);

        if (payment.getStatus() == PaymentStatus.PAID) {
            return; // idempotência
        }

        payment.markAsPaid();
        paymentGateway.update(payment);

        reservationGateway.confirmReservation(
                payment.getReservationId()
        );
    }

    private void handleFailed(Event event) {

        PaymentIntent intent =
                (PaymentIntent) event
                        .getDataObjectDeserializer()
                        .getObject()
                        .orElseThrow();

        String providerReference = intent.getId();

        var payment =
                paymentGateway.findByProviderReference(providerReference);

        payment.markAsFailed();
        paymentGateway.update(payment);

        reservationGateway.cancelReservation(
                payment.getReservationId()
        );
    }
}