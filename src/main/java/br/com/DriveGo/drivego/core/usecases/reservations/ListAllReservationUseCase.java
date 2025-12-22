package br.com.DriveGo.drivego.core.usecases.reservations;

import br.com.DriveGo.drivego.core.entities.Reservation;

import java.util.List;

public interface ListAllReservationUseCase {

    List<Reservation> execute();
}
