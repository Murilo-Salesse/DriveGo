package br.com.DriveGo.drivego.core.usecases.vehicles;

import br.com.DriveGo.drivego.core.entities.Vehicle;
import br.com.DriveGo.drivego.core.gateways.VehicleGateway;

import java.util.UUID;

public class FindByIdVehicleUseCaseImp implements FindByIdVehicleUseCase{

    private final VehicleGateway vehicleGateway;

    public FindByIdVehicleUseCaseImp(VehicleGateway vehicleGateway) {
        this.vehicleGateway = vehicleGateway;
    }

    @Override
    public Vehicle execute(UUID id) {
        return vehicleGateway.findById(id);
    }
}
