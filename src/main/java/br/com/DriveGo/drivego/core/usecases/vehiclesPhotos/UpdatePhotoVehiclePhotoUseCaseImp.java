package br.com.DriveGo.drivego.core.usecases.vehiclesPhotos;

import br.com.DriveGo.drivego.core.entities.VehiclePhoto;
import br.com.DriveGo.drivego.core.gateways.VehiclePhotoGateway;

import java.util.UUID;

public class UpdatePhotoVehiclePhotoUseCaseImp implements UpdatePhotoVehiclePhotoUseCase{

    private final VehiclePhotoGateway vehiclePhotoGateway;

    public UpdatePhotoVehiclePhotoUseCaseImp(VehiclePhotoGateway vehiclePhotoGateway) {
        this.vehiclePhotoGateway = vehiclePhotoGateway;
    }

    @Override
    public VehiclePhoto execute(VehiclePhoto vehiclePhoto, UUID id) {
        return vehiclePhotoGateway.updatePhoto(vehiclePhoto, id);
    }
}
