package br.com.DriveGo.drivego.core.usecases.reservations;

import br.com.DriveGo.drivego.core.entities.Reservation;

import java.util.UUID;

public interface UpdateReservationUseCase {
    Reservation execute(UUID reservationId, Reservation reservation);
}
