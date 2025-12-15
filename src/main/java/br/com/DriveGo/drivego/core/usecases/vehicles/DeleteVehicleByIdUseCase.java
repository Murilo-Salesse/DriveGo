package br.com.DriveGo.drivego.core.usecases.vehicles;

import java.util.UUID;

public interface DeleteVehicleByIdUseCase {

    Void execute(UUID id);
}
