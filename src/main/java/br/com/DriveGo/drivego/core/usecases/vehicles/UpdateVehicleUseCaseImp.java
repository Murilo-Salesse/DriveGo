package br.com.DriveGo.drivego.core.usecases.vehicles;

import br.com.DriveGo.drivego.core.entities.Vehicle;
import br.com.DriveGo.drivego.core.gateways.VehicleGateway;

import java.util.UUID;

public class UpdateVehicleUseCaseImp implements UpdateVehicleUseCase{

    private final VehicleGateway vehicleGateway;

    public UpdateVehicleUseCaseImp(VehicleGateway vehicleGateway) {
        this.vehicleGateway = vehicleGateway;
    }

    @Override
    public Vehicle execute(Vehicle vehicle, UUID id) {
        return vehicleGateway.updateVehicle(vehicle, id);
    }
}
