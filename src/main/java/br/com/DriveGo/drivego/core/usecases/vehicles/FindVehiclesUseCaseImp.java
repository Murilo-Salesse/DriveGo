package br.com.DriveGo.drivego.core.usecases.vehicles;

import br.com.DriveGo.drivego.core.entities.Vehicle;
import br.com.DriveGo.drivego.core.gateways.VehicleGateway;

import java.util.List;

public class FindVehiclesUseCaseImp implements FindVehiclesUseCase{

    private final VehicleGateway vehicleGateway;

    public FindVehiclesUseCaseImp(VehicleGateway vehicleGateway) {
        this.vehicleGateway = vehicleGateway;
    }

    @Override
    public List<Vehicle> execute(String brand, String model, Short year, String licensePlate, String vin) {
        return vehicleGateway.findVehicles(brand, model, year, licensePlate, vin);
    }
}
