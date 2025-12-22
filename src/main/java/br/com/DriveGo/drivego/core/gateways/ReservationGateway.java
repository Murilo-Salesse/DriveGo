package br.com.DriveGo.drivego.core.gateways;

import br.com.DriveGo.drivego.core.entities.Reservation;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface ReservationGateway {

    Reservation createReservation(Reservation reservation);
    Reservation findById(UUID id);
    Reservation update(Reservation reservation);
    List<Reservation> listAll();
    Long totalReservations();
    BigDecimal countTotalReservationCost(UUID id);
}
