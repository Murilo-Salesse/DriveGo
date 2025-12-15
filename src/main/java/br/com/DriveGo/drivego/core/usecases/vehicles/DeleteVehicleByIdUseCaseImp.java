package br.com.DriveGo.drivego.core.usecases.vehicles;

import br.com.DriveGo.drivego.core.gateways.VehicleGateway;

import java.util.UUID;

public class DeleteVehicleByIdUseCaseImp implements DeleteVehicleByIdUseCase {

    private final VehicleGateway vehicleGateway;

    public DeleteVehicleByIdUseCaseImp(VehicleGateway vehicleGateway) {
        this.vehicleGateway = vehicleGateway;
    }

    @Override
    public Void execute(UUID id) {
        return vehicleGateway.deleteById(id);
    }
}
