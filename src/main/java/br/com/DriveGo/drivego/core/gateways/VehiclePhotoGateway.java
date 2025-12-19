package br.com.DriveGo.drivego.core.gateways;

import br.com.DriveGo.drivego.core.entities.VehiclePhoto;

import java.util.List;
import java.util.UUID;

public interface VehiclePhotoGateway {

    VehiclePhoto createVehiclePhoto(VehiclePhoto vehiclePhoto);
    VehiclePhoto findById(UUID id);
    List<VehiclePhoto> listAllPhotosVehicles();
    VehiclePhoto updatePhoto(VehiclePhoto vehiclePhoto, UUID id);
    void deleteById(UUID id);
}
