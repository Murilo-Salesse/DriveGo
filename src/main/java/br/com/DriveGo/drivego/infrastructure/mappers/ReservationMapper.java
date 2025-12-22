package br.com.DriveGo.drivego.infrastructure.mappers;

import br.com.DriveGo.drivego.core.entities.Reservation;
import br.com.DriveGo.drivego.infrastructure.dtos.requests.ReservationRequest;
import br.com.DriveGo.drivego.infrastructure.dtos.requests.ReservationUpdateRequest;
import br.com.DriveGo.drivego.infrastructure.dtos.responses.ReservationResponse;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.UUID;

@UtilityClass
public class ReservationMapper {

    // Converte de ReservationRequest (entrada) para ReservationModel (entidade do pura do core)
    public static Reservation toDomain(ReservationRequest request, UUID userId) {

        return new Reservation(
                null,
                userId,
                request.getVehicleId(),
                request.getStartDate().atStartOfDay(),
                request.getEndDate().atTime(23, 59, 59),
                null,
                null,
                null,
                null,
                null
        );
    }

    public static Reservation toDomainUpdate(ReservationUpdateRequest request) {
        Reservation reservation = new Reservation();

        reservation.setStartDateTime(
                request.getStartDate().atStartOfDay()
        );

        reservation.setEndDateTime(
                request.getEndDate().atTime(23, 59, 59)
        );

        return reservation;
    }

    public static ReservationResponse toResponse(Reservation r) {

        return new ReservationResponse(
                r.getId(),
                r.getVehicleId(),
                r.getUserId(),
                r.getStatus(),
                r.getStartDateTime(),
                r.getEndDateTime(),
                r.getTotalAmount(),
                r.getDepositAmount(),
                r.getCreatedAt()
        );
    }

    public static List<ReservationResponse> toResponseList(List<Reservation> r) {
        return r.stream()
                .map(ReservationMapper::toResponse)
                .toList();
    }
}
