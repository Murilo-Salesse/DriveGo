package br.com.DriveGo.drivego.core.usecases.reservations;

import br.com.DriveGo.drivego.core.gateways.ReservationGateway;

public class CountTotalReservationUseCaseImp implements CountTotalReservationUseCase{

    private final ReservationGateway reservationGateway;

    public CountTotalReservationUseCaseImp(ReservationGateway reservationGateway) {
        this.reservationGateway = reservationGateway;
    }

    @Override
    public Long execute() {
        return reservationGateway.totalReservations();
    }
}
