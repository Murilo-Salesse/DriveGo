package br.com.DriveGo.drivego.core.usecases.vehiclesPhotos;

import br.com.DriveGo.drivego.core.entities.VehiclePhoto;

import java.util.UUID;

public interface UpdatePhotoVehiclePhotoUseCase {

    VehiclePhoto execute(VehiclePhoto vehiclePhoto, UUID id);
}
