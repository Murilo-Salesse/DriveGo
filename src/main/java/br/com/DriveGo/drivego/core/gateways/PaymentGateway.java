package br.com.DriveGo.drivego.core.gateways;

import br.com.DriveGo.drivego.core.entities.Payment;

public interface PaymentGateway {

    Payment createPayment(Payment payment);

    Payment findByProviderReference(String providerReference);

    Payment update(Payment payment);
}
