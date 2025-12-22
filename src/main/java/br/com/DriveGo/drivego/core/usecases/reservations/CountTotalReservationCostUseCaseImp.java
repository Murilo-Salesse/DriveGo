package br.com.DriveGo.drivego.core.usecases.reservations;

import br.com.DriveGo.drivego.core.exceptions.BusinessException;
import br.com.DriveGo.drivego.core.gateways.ReservationGateway;

import java.math.BigDecimal;
import java.util.UUID;

public class CountTotalReservationCostUseCaseImp implements CountTotalReservationCostUseCase{

    private final ReservationGateway reservationGateway;

    public CountTotalReservationCostUseCaseImp(ReservationGateway reservationGateway) {
        this.reservationGateway = reservationGateway;
    }

    @Override
    public BigDecimal execute(UUID id) {

        if (id == null) {
            throw new BusinessException("Usuário não encontrado.");
        }

        return reservationGateway.countTotalReservationCost(id);
    }
}
