package br.com.DriveGo.drivego.core.usecases.reservations;

import br.com.DriveGo.drivego.core.entities.Reservation;
import br.com.DriveGo.drivego.core.entities.User;
import br.com.DriveGo.drivego.core.entities.Vehicle;
import br.com.DriveGo.drivego.core.enums.ReservationStatus;
import br.com.DriveGo.drivego.core.exceptions.BusinessException;
import br.com.DriveGo.drivego.core.exceptions.NotFoundException;
import br.com.DriveGo.drivego.core.gateways.ReservationGateway;
import br.com.DriveGo.drivego.core.gateways.UserGateway;
import br.com.DriveGo.drivego.core.gateways.VehicleGateway;

import java.math.BigDecimal;

public class CreateReservationUseCaseImp implements CreateReservationUseCase {

    private final ReservationGateway reservationGateway;
    private final VehicleGateway vehicleGateway;
    private final UserGateway userGateway;

    public CreateReservationUseCaseImp(ReservationGateway reservationGateway,
                                       VehicleGateway vehicleGateway,
                                       UserGateway userGateway) {
        this.reservationGateway = reservationGateway;
        this.vehicleGateway = vehicleGateway;
        this.userGateway = userGateway;
    }

    @Override
    public Reservation execute(Reservation reservation) {

        if (reservation.getUserId() == null) {
            throw new IllegalArgumentException("ID do usuário não pode ser nulo");
        }

        if (!reservation.getStartDateTime().isBefore(reservation.getEndDateTime())) {
            throw new BusinessException("Data inicial deve ser antes da data final");
        }

        Vehicle vehicle = vehicleGateway.findById(reservation.getVehicleId());
        if (vehicle == null) {
            throw new NotFoundException("Veículo não encontrado");
        }

        BigDecimal dailyRate = vehicle.getDaily_price();

        reservation.setStatus(ReservationStatus.PENDING);
        reservation.calculateTotalAmount(dailyRate);
        reservation.calculateDeposit();

        return reservationGateway.createReservation(reservation);
    }
}
