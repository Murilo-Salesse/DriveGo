package br.com.DriveGo.drivego.core.usecases.reservations;

import br.com.DriveGo.drivego.core.entities.Reservation;
import br.com.DriveGo.drivego.core.exceptions.NotFoundException;
import br.com.DriveGo.drivego.core.gateways.ReservationGateway;

import java.util.UUID;

public class FindReservationByIdUseCaseImp implements FindReservationByIdUseCase{

    private final ReservationGateway reservationGateway;

    public FindReservationByIdUseCaseImp(ReservationGateway reservationGateway) {
        this.reservationGateway = reservationGateway;
    }

    @Override
    public Reservation execute(UUID id) {
        if (id == null) {
            throw new IllegalArgumentException("ID da reserva não pode ser nulo");
        }

        return reservationGateway.findById(id);
    }
}
