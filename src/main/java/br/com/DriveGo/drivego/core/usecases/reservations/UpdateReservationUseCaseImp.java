package br.com.DriveGo.drivego.core.usecases.reservations;

import br.com.DriveGo.drivego.core.entities.Reservation;
import br.com.DriveGo.drivego.core.entities.Vehicle;
import br.com.DriveGo.drivego.core.enums.ReservationStatus;
import br.com.DriveGo.drivego.core.exceptions.BusinessException;
import br.com.DriveGo.drivego.core.exceptions.NotFoundException;
import br.com.DriveGo.drivego.core.gateways.ReservationGateway;
import br.com.DriveGo.drivego.core.gateways.VehicleGateway;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

public class UpdateReservationUseCaseImp implements UpdateReservationUseCase {

    private final ReservationGateway reservationGateway;
    private final VehicleGateway vehicleGateway;

    public UpdateReservationUseCaseImp(ReservationGateway reservationGateway,
                                       VehicleGateway vehicleGateway) {
        this.reservationGateway = reservationGateway;
        this.vehicleGateway = vehicleGateway;
    }

    @Override
    public Reservation execute(UUID reservationId, Reservation updatedData) {
        Objects.requireNonNull(reservationId, "ID da reserva é obrigatório");

        Reservation current = reservationGateway.findById(reservationId);

        if (current.getStatus() != ReservationStatus.PENDING) {
            throw new BusinessException(
                    "Somente reservas PENDING podem ser alteradas"
            );
        }

        current.setStartDateTime(updatedData.getStartDateTime());
        current.setEndDateTime(updatedData.getEndDateTime());

        Vehicle vehicle = vehicleGateway.findById(current.getVehicleId());
        if (vehicle == null) {
            throw new NotFoundException("Veículo não encontrado");
        }

        BigDecimal dailyRate = vehicle.getDaily_price();

        current.calculateTotalAmount(dailyRate);
        current.calculateDeposit();

        return reservationGateway.update(current);
    }
}
