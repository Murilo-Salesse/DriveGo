package br.com.DriveGo.drivego.core.gateways;

import br.com.DriveGo.drivego.infrastructure.dtos.responses.StripePaymentResponse;

import java.math.BigDecimal;

public interface StripeGateway {

    StripePaymentResponse createPayment(
            BigDecimal amount,
            String method
    );
}
