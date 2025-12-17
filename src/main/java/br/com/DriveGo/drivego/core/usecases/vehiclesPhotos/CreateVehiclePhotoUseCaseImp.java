package br.com.DriveGo.drivego.core.usecases.vehiclesPhotos;

import br.com.DriveGo.drivego.core.entities.VehiclePhoto;
import br.com.DriveGo.drivego.core.gateways.VehiclePhotoGateway;

public class CreateVehiclePhotoUseCaseImp implements CreateVehiclePhotoUseCase {

    private final VehiclePhotoGateway vehiclePhotoGateway;

    public CreateVehiclePhotoUseCaseImp(VehiclePhotoGateway vehiclePhotoGateway) {
        this.vehiclePhotoGateway = vehiclePhotoGateway;
    }

    @Override
    public VehiclePhoto execute(VehiclePhoto vehiclePhoto) {
        return vehiclePhotoGateway.createVehiclePhoto(vehiclePhoto);
    }
}
