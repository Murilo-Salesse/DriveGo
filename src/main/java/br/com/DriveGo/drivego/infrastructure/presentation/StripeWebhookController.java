package br.com.DriveGo.drivego.infrastructure.presentation;

import br.com.DriveGo.drivego.core.usecases.stripe.HandleStripeWebhookUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/webhooks/stripe")
public class StripeWebhookController {

    private final HandleStripeWebhookUseCase handleStripeWebhookUseCase;

    public StripeWebhookController(
            HandleStripeWebhookUseCase handleStripeWebhookUseCase
    ) {
        this.handleStripeWebhookUseCase = handleStripeWebhookUseCase;
    }

    @PostMapping
    public ResponseEntity<Void> handle(
            @RequestBody String payload,
            @RequestHeader("Stripe-Signature") String signature
    ) {
        handleStripeWebhookUseCase.execute(payload, signature);
        return ResponseEntity.ok().build();
    }
}