package br.com.DriveGo.drivego.core.usecases.vehicles;

import br.com.DriveGo.drivego.core.entities.Vehicle;
import br.com.DriveGo.drivego.core.gateways.VehicleGateway;

import java.util.List;

public class ListAllVehiclesUseCaseImp implements ListAllVehiclesUseCase {

    private final VehicleGateway vehicleGateway;

    public ListAllVehiclesUseCaseImp(VehicleGateway vehicleGateway) {
        this.vehicleGateway = vehicleGateway;
    }

    @Override
    public List<Vehicle> listAllVehicle() {
        return vehicleGateway.listAllVehicle();
    }
}
