package br.com.DriveGo.drivego.core.usecases.vehicles;

import br.com.DriveGo.drivego.core.entities.Vehicle;
import br.com.DriveGo.drivego.core.gateways.VehicleGateway;
import br.com.DriveGo.drivego.infrastructure.exceptions.DuplicateException;

public class CreateVehicleUseCaseImp implements CreateVehicleUseCase {

    private final VehicleGateway vehicleGateway;

    public CreateVehicleUseCaseImp(VehicleGateway vehicleGateway) {
        this.vehicleGateway = vehicleGateway;
    }

    @Override
    public Vehicle execute(Vehicle vehicle) {
        validateUniqueLicensePlate(vehicle.getLicense_plate());
        validateUniqueVin(vehicle.getVin());

        return vehicleGateway.createVehicle(vehicle);
    }

    private void validateUniqueLicensePlate(String licensePlate) {
        Vehicle existing = vehicleGateway.findByLicensePlate(licensePlate);
        if (existing != null) {
            throw new DuplicateException(
                    "Veículo com placa " + licensePlate + " já está cadastrado"
            );
        }
    }

    private void validateUniqueVin(String vin) {
        Vehicle existing = vehicleGateway.findByVin(vin);
        if (existing != null) {
            throw new DuplicateException(
                    "Veículo com VIN " + vin + " já está cadastrado"
            );
        }
    }
}