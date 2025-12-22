package br.com.DriveGo.drivego.core.usecases.vehiclesPhotos;

import br.com.DriveGo.drivego.core.entities.VehiclePhoto;
import br.com.DriveGo.drivego.core.gateways.VehiclePhotoGateway;
import br.com.DriveGo.drivego.core.exceptions.NotFoundException;

import java.util.UUID;

public class UpdatePhotoVehiclePhotoUseCaseImp implements UpdatePhotoVehiclePhotoUseCase {

    private final VehiclePhotoGateway vehiclePhotoGateway;

    public UpdatePhotoVehiclePhotoUseCaseImp(VehiclePhotoGateway vehiclePhotoGateway) {
        this.vehiclePhotoGateway = vehiclePhotoGateway;
    }

    @Override
    public VehiclePhoto execute(VehiclePhoto vehiclePhoto, UUID id) {
        validatePhotoExists(id);
        return vehiclePhotoGateway.updatePhoto(vehiclePhoto, id);
    }

    private void validatePhotoExists(UUID id) {
        VehiclePhoto existing = vehiclePhotoGateway.findById(id);
        if (existing == null) {
            throw new NotFoundException("Foto não encontrada com ID: " + id);
        }
    }
}
