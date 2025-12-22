package br.com.DriveGo.drivego.core.usecases.vehiclesPhotos;

import br.com.DriveGo.drivego.core.entities.VehiclePhoto;
import br.com.DriveGo.drivego.core.gateways.VehicleGateway;
import br.com.DriveGo.drivego.core.gateways.VehiclePhotoGateway;
import br.com.DriveGo.drivego.core.exceptions.NotFoundException;

public class CreateVehiclePhotoUseCaseImp implements CreateVehiclePhotoUseCase {

    private final VehiclePhotoGateway vehiclePhotoGateway;
    private final VehicleGateway vehicleGateway;

    public CreateVehiclePhotoUseCaseImp(
            VehiclePhotoGateway vehiclePhotoGateway,
            VehicleGateway vehicleGateway
    ) {
        this.vehiclePhotoGateway = vehiclePhotoGateway;
        this.vehicleGateway = vehicleGateway;
    }

    @Override
    public VehiclePhoto execute(VehiclePhoto vehiclePhoto) {
        validateVehicleExists(vehiclePhoto.getVehicle_id());
        return vehiclePhotoGateway.createVehiclePhoto(vehiclePhoto);
    }

    private void validateVehicleExists(java.util.UUID vehicleId) {
        if (vehicleGateway.findById(vehicleId) == null) {
            throw new NotFoundException(
                    "Veículo não encontrado com ID: " + vehicleId
            );
        }
    }
}
