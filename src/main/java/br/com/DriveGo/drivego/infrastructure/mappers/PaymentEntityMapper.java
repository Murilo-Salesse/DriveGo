package br.com.DriveGo.drivego.infrastructure.mappers;

import br.com.DriveGo.drivego.core.entities.Payment;
import br.com.DriveGo.drivego.infrastructure.persistence.PaymentEntity;
import br.com.DriveGo.drivego.infrastructure.persistence.ReservationEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class PaymentEntityMapper {

    public static PaymentEntity toEntity(Payment payment,
                                         ReservationEntity reservation) {

        PaymentEntity entity = new PaymentEntity();

        entity.setId(payment.getId());
        entity.setReservation(reservation);
        entity.setAmount(payment.getAmount());
        entity.setMethod(payment.getMethod());
        entity.setProvider(payment.getProvider());
        entity.setStatus(payment.getStatus());
        entity.setProviderReference(payment.getProviderReference());

        return entity;
    }

    public static Payment toDomain(PaymentEntity entity) {
        return new Payment(
                entity.getId(),
                entity.getReservation().getId(),
                entity.getAmount(),
                entity.getMethod(),
                entity.getProvider(),
                entity.getStatus(),
                entity.getProviderReference(),
                entity.getCreatedAt()
        );
    }
}