package br.com.DriveGo.drivego.core.usecases.reservations;

import br.com.DriveGo.drivego.core.entities.Reservation;

public interface CreateReservationUseCase {

    Reservation execute(Reservation reservation);
}
