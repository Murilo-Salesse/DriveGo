package br.com.DriveGo.drivego.core.usecases.payments;

import br.com.DriveGo.drivego.core.entities.Payment;

import java.util.UUID;

public interface CreatePaymentUseCase {
    Payment execute(UUID reservationId, String method);
}
