package br.com.DriveGo.drivego.infrastructure.mappers;

import br.com.DriveGo.drivego.core.entities.Payment;
import br.com.DriveGo.drivego.core.enums.PaymentStatus;
import br.com.DriveGo.drivego.infrastructure.dtos.requests.PaymentRequest;
import br.com.DriveGo.drivego.infrastructure.dtos.responses.PaymentResponse;
import lombok.experimental.UtilityClass;

import java.math.BigDecimal;
import java.util.UUID;

@UtilityClass
public class PaymentMapper {

    public static Payment toDomain(PaymentRequest request,
                                   UUID reservationId,
                                   BigDecimal amount,
                                   String provider,
                                   String providerReference) {

        return new Payment(
                null,
                reservationId,
                amount,
                request.getMethod(),
                provider,
                PaymentStatus.PENDING,
                providerReference,
                null
        );
    }

    public static PaymentResponse toResponse(Payment payment, String clientSecret) {
        return new PaymentResponse(
                payment.getId(),
                payment.getReservationId(),
                payment.getAmount(),
                payment.getStatus(),
                payment.getProvider(),
                payment.getProviderReference(),
                clientSecret,
                payment.getCreatedAt()
        );
    }
}