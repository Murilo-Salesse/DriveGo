package br.com.DriveGo.drivego.core.usecases.vehiclesPhotos;

import java.util.UUID;

public interface DeleteVehiclePhotoByIdUseCase {

    Void execute(UUID id);
}
