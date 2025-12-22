package br.com.DriveGo.drivego.core.usecases.vehiclesPhotos;

import br.com.DriveGo.drivego.core.entities.VehiclePhoto;
import br.com.DriveGo.drivego.core.gateways.VehiclePhotoGateway;
import br.com.DriveGo.drivego.core.exceptions.NotFoundException;

import java.util.UUID;

public class FindByIdVehiclePhotoUseCaseImp implements FindByIdVehiclePhotoUseCase {

    private final VehiclePhotoGateway vehiclePhotoGateway;

    public FindByIdVehiclePhotoUseCaseImp(VehiclePhotoGateway vehiclePhotoGateway) {
        this.vehiclePhotoGateway = vehiclePhotoGateway;
    }

    @Override
    public VehiclePhoto execute(UUID id) {
        VehiclePhoto photo = vehiclePhotoGateway.findById(id);

        if (photo == null) {
            throw new NotFoundException("Foto não encontrada com ID: " + id);
        }

        return photo;
    }
}
