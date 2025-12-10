package br.com.DriveGo.drivego.core.usecases.vehicles;

import br.com.DriveGo.drivego.core.entities.Vehicle;
import br.com.DriveGo.drivego.core.gateways.VehicleGateway;

public class CreateVehicleUseCaseImp implements CreateVehicleUseCase{

    private final VehicleGateway vehicleGateway;

    public CreateVehicleUseCaseImp(VehicleGateway vehicleGateway) {
        this.vehicleGateway = vehicleGateway;
    }

    @Override
    public Vehicle execute(Vehicle vehicle) {
        return vehicleGateway.createVehicle(vehicle);
    }
}
