package br.com.DriveGo.drivego.infrastructure.mappers;

import br.com.DriveGo.drivego.core.entities.Reservation;
import br.com.DriveGo.drivego.infrastructure.persistence.ReservationEntity;
import br.com.DriveGo.drivego.infrastructure.persistence.UserEntity;
import br.com.DriveGo.drivego.infrastructure.persistence.VehicleEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ReservationEntityMapper {

    // Converte de ReservationRequest(entrada) para ReservationEntity (entidade para salvar no banco)
    public static ReservationEntity toEntity(Reservation reservation,
                                                UserEntity user,
                                                VehicleEntity vehicle) {
        ReservationEntity entity = new ReservationEntity();

        entity.setId(reservation.getId());
        entity.setUser(user);
        entity.setVehicle(vehicle);
        entity.setStartDateTime(reservation.getStartDateTime());
        entity.setEndDateTime(reservation.getEndDateTime());
        entity.setStatus(reservation.getStatus());
        entity.setTotalAmount(reservation.getTotalAmount());
        entity.setDepositAmount(reservation.getDepositAmount());

        return entity;
    }


    // Converte de ReservationEntity (entidade do banco) para ReservationRequest (saida)
    public static Reservation toDomain(ReservationEntity entity) {

        return new Reservation(
            entity.getId(),
            entity.getUser().getId(),
            entity.getVehicle().getId(),
            entity.getStartDateTime(),
            entity.getEndDateTime(),
            entity.getStatus(),
            entity.getTotalAmount(),
            entity.getDepositAmount(),
            entity.getCreatedAt(),
            entity.getUpdatedAt()
        );
    }
}
