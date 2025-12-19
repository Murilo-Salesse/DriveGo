package br.com.DriveGo.drivego.core.usecases.vehicles;

import br.com.DriveGo.drivego.core.entities.Vehicle;
import br.com.DriveGo.drivego.core.gateways.VehicleGateway;
import br.com.DriveGo.drivego.infrastructure.exceptions.DuplicateException;
import br.com.DriveGo.drivego.infrastructure.exceptions.NotFoundException;

import java.util.UUID;

public class UpdateVehicleUseCaseImp implements UpdateVehicleUseCase {

    private final VehicleGateway vehicleGateway;

    public UpdateVehicleUseCaseImp(VehicleGateway vehicleGateway) {
        this.vehicleGateway = vehicleGateway;
    }

    @Override
    public Vehicle execute(Vehicle vehicle, UUID id) {
        validateVehicleExists(id);
        validateLicensePlateNotInUseByOther(vehicle.getLicense_plate(), id);
        validateVinNotInUseByOther(vehicle.getVin(), id);

        return vehicleGateway.updateVehicle(vehicle, id);
    }

    private void validateVehicleExists(UUID id) {
        Vehicle existing = vehicleGateway.findById(id);
        if (existing == null) {
            throw new NotFoundException("Veículo não encontrado com ID: " + id);
        }
    }

    private void validateLicensePlateNotInUseByOther(String licensePlate, UUID excludeId) {
        Vehicle existing = vehicleGateway.findByLicensePlateExcludingId(licensePlate, excludeId);
        if (existing != null) {
            throw new DuplicateException(
                    "Veículo com placa " + licensePlate + " já está cadastrado"
            );
        }
    }

    private void validateVinNotInUseByOther(String vin, UUID excludeId) {
        Vehicle existing = vehicleGateway.findByVinExcludingId(vin, excludeId);
        if (existing != null) {
            throw new DuplicateException(
                    "Veículo com VIN " + vin + " já está cadastrado"
            );
        }
    }
}
