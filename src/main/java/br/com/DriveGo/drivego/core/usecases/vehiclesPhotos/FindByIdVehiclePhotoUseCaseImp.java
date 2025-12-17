package br.com.DriveGo.drivego.core.usecases.vehiclesPhotos;

import br.com.DriveGo.drivego.core.entities.VehiclePhoto;
import br.com.DriveGo.drivego.core.gateways.VehiclePhotoGateway;

import java.util.UUID;

public class FindByIdVehiclePhotoUseCaseImp implements FindByIdVehiclePhotoUseCase{

    private final VehiclePhotoGateway vehiclePhotoGateway;

    public FindByIdVehiclePhotoUseCaseImp(VehiclePhotoGateway vehiclePhotoGateway) {
        this.vehiclePhotoGateway = vehiclePhotoGateway;
    }

    @Override
    public VehiclePhoto execute(UUID id) {
        return vehiclePhotoGateway.findById(id);
    }
}
