package br.com.DriveGo.drivego.core.usecases.vehiclesPhotos;

import br.com.DriveGo.drivego.core.gateways.VehicleGateway;
import br.com.DriveGo.drivego.core.gateways.VehiclePhotoGateway;

import java.util.UUID;

public class DeleteVehiclePhotoByIdUseCaseImp implements DeleteVehiclePhotoByIdUseCase{

   private final VehiclePhotoGateway vehiclePhotoGateway;

    public DeleteVehiclePhotoByIdUseCaseImp(VehiclePhotoGateway vehiclePhotoGateway) {
        this.vehiclePhotoGateway = vehiclePhotoGateway;
    }

    @Override
    public Void execute(UUID id) {
        return vehiclePhotoGateway.deleteById(id);
    }
}
