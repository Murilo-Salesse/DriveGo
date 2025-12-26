package br.com.DriveGo.drivego.core.usecases.stripe;

public interface HandleStripeWebhookUseCase {
    void execute(String payload, String signature);
}
