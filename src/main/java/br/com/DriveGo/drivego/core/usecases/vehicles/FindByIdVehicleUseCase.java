package br.com.DriveGo.drivego.core.usecases.vehicles;

import br.com.DriveGo.drivego.core.entities.Vehicle;

import java.util.UUID;

public interface FindByIdVehicleUseCase {

    Vehicle execute(UUID id);
}
