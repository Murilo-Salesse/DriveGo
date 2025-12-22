package br.com.DriveGo.drivego.core.usecases.vehiclesPhotos;

import br.com.DriveGo.drivego.core.gateways.VehiclePhotoGateway;
import br.com.DriveGo.drivego.core.exceptions.NotFoundException;

import java.util.UUID;

public class DeleteVehiclePhotoByIdUseCaseImp implements DeleteVehiclePhotoByIdUseCase {

    private final VehiclePhotoGateway vehiclePhotoGateway;

    public DeleteVehiclePhotoByIdUseCaseImp(VehiclePhotoGateway vehiclePhotoGateway) {
        this.vehiclePhotoGateway = vehiclePhotoGateway;
    }

    @Override
    public Void execute(UUID id) {
        validatePhotoExists(id);
        vehiclePhotoGateway.deleteById(id);
        return null;
    }

    private void validatePhotoExists(UUID id) {
        if (vehiclePhotoGateway.findById(id) == null) {
            throw new NotFoundException("Foto não encontrada com ID: " + id);
        }
    }
}
