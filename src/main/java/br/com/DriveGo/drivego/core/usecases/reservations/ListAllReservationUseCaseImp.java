package br.com.DriveGo.drivego.core.usecases.reservations;

import br.com.DriveGo.drivego.core.entities.Reservation;
import br.com.DriveGo.drivego.core.gateways.ReservationGateway;

import java.util.List;

public class ListAllReservationUseCaseImp implements ListAllReservationUseCase {

    private final ReservationGateway reservationGateway;

    public ListAllReservationUseCaseImp(ReservationGateway reservationGateway) {
        this.reservationGateway = reservationGateway;
    }

    @Override
    public List<Reservation> execute() {
        return reservationGateway.listAll();
    }
}
