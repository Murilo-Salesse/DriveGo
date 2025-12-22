package br.com.DriveGo.drivego.core.usecases.payments;

import br.com.DriveGo.drivego.core.entities.Payment;
import br.com.DriveGo.drivego.core.entities.Reservation;
import br.com.DriveGo.drivego.core.enums.PaymentStatus;
import br.com.DriveGo.drivego.core.enums.ReservationStatus;
import br.com.DriveGo.drivego.core.exceptions.BusinessException;
import br.com.DriveGo.drivego.core.gateways.PaymentGateway;
import br.com.DriveGo.drivego.core.gateways.ReservationGateway;
import br.com.DriveGo.drivego.core.gateways.StripeGateway;
import br.com.DriveGo.drivego.infrastructure.dtos.responses.StripePaymentResponse;

import java.math.BigDecimal;
import java.util.UUID;

public class CreatePaymentUseCaseImp implements CreatePaymentUseCase {

    private final PaymentGateway paymentGateway;
    private final ReservationGateway reservationGateway;
    private final StripeGateway stripeGateway;

    public CreatePaymentUseCaseImp(PaymentGateway paymentGateway,
                                   ReservationGateway reservationGateway,
                                   StripeGateway stripeGateway) {
        this.paymentGateway = paymentGateway;
        this.reservationGateway = reservationGateway;
        this.stripeGateway = stripeGateway;
    }

    @Override
    public Payment execute(UUID reservationId, String method) {

        Reservation reservation =
                reservationGateway.findById(reservationId);

        if (reservation.getStatus() != ReservationStatus.PENDING) {
            throw new BusinessException(
                    "Pagamento só permitido para reservas PENDING"
            );
        }

        BigDecimal amount = reservation.getDepositAmount();

        StripePaymentResponse stripeResult =
                stripeGateway.createPayment(amount, method);

        Payment payment = new Payment(
                null,
                reservation.getId(),
                amount,
                method,
                "STRIPE",
                PaymentStatus.PENDING,
                stripeResult.getPaymentIntentId(),
                null
        );

        return paymentGateway.createPayment(payment);
    }
}

