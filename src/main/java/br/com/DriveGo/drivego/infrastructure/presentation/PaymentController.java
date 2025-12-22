package br.com.DriveGo.drivego.infrastructure.presentation;

import br.com.DriveGo.drivego.core.usecases.payments.CreatePaymentUseCase;
import br.com.DriveGo.drivego.infrastructure.dtos.requests.PaymentRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final CreatePaymentUseCase createPaymentUseCase;

    public PaymentController(CreatePaymentUseCase createPaymentUseCase) {
        this.createPaymentUseCase = createPaymentUseCase;
    }

    @PostMapping
    public ResponseEntity<?> createPayment(
            @RequestBody PaymentRequest request
    ) {
        var result = createPaymentUseCase.execute(
                request.getReservationId(),
                request.getMethod()
        );

        return ResponseEntity.ok(result);
    }
}

