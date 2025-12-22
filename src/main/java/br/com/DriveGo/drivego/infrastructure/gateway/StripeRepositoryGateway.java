package br.com.DriveGo.drivego.infrastructure.gateway;

import br.com.DriveGo.drivego.core.exceptions.PaymentProviderException;
import br.com.DriveGo.drivego.infrastructure.dtos.responses.StripePaymentResponse;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Component
public class StripeRepositoryGateway implements br.com.DriveGo.drivego.core.gateways.StripeGateway {

    @Value("${stripe.api.key}")
    private String apiKey;

    @PostConstruct
    public void init() {
        Stripe.apiKey = apiKey;
    }

    @Override
    public StripePaymentResponse createPayment(
            BigDecimal amount,
            String method
    ) {
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("amount", amount.multiply(BigDecimal.valueOf(100)).intValue());
            params.put("currency", "brl");

            PaymentIntent intent = PaymentIntent.create(params);

            return new StripePaymentResponse(
                    intent.getId(),
                    intent.getClientSecret()
            );

        } catch (StripeException e) {
            throw new PaymentProviderException(
                    "Erro ao criar pagamento na Stripe"
            );
        }
    }
}

