package br.com.DriveGo.drivego.core.usecases.reservations;

import java.math.BigDecimal;
import java.util.UUID;

public interface CountTotalReservationCostUseCase {

    BigDecimal execute(UUID id);
}
