package br.com.DriveGo.drivego.core.usecases.vehiclesPhotos;

import br.com.DriveGo.drivego.core.entities.VehiclePhoto;
import br.com.DriveGo.drivego.core.gateways.VehiclePhotoGateway;

import java.util.List;

public class ListAllVehiclePhotosUseCaseImp implements ListAllVehiclePhotosUseCase{

    private final VehiclePhotoGateway vehiclePhotoGateway;

    public ListAllVehiclePhotosUseCaseImp(VehiclePhotoGateway vehiclePhotoGateway) {
        this.vehiclePhotoGateway = vehiclePhotoGateway;
    }

    @Override
    public List<VehiclePhoto> execute() {
        return vehiclePhotoGateway.listAllPhotosVehicles();
    }
}
