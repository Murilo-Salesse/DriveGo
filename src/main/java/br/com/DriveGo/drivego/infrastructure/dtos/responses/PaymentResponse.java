package br.com.DriveGo.drivego.infrastructure.dtos.responses;

import br.com.DriveGo.drivego.core.enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentResponse {

    private UUID id;
    private UUID reservationId;
    private BigDecimal amount;
    private PaymentStatus status;
    private String provider;
    private String providerReference;
    private String clientSecret;
    private LocalDateTime createdAt;
}
