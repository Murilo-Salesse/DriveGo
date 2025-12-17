package br.com.DriveGo.drivego.core.gateways;

import br.com.DriveGo.drivego.core.entities.VehiclePhoto;

import java.util.List;
import java.util.UUID;

public interface VehiclePhotoGateway {

    VehiclePhoto createVehiclePhoto(VehiclePhoto vehiclePhoto);
    List<VehiclePhoto> listAllPhotosVehicles();
    VehiclePhoto findById(UUID id);
    VehiclePhoto updatePhoto(VehiclePhoto vehiclePhoto, UUID id);
    Void deleteById(UUID id);
}
