package br.com.DriveGo.drivego.infrastructure.gateway;

import br.com.DriveGo.drivego.core.entities.VehiclePhoto;
import br.com.DriveGo.drivego.core.gateways.VehiclePhotoGateway;
import br.com.DriveGo.drivego.infrastructure.exceptions.NotFoundException;
import br.com.DriveGo.drivego.infrastructure.mappers.VehiclePhotosEntityMapper;
import br.com.DriveGo.drivego.infrastructure.persistence.VehicleEntity;
import br.com.DriveGo.drivego.infrastructure.persistence.VehiclePhotosEntity;
import br.com.DriveGo.drivego.infrastructure.persistence.VehiclePhotosRepository;
import br.com.DriveGo.drivego.infrastructure.persistence.VehicleRepository;

public class VehiclePhotosRepositoryGateway implements VehiclePhotoGateway {

    private final VehiclePhotosRepository vehiclePhotosRepository;
    private final VehicleRepository vehicleRepository;

    public VehiclePhotosRepositoryGateway(VehiclePhotosRepository vehiclePhotosRepository, VehicleRepository vehicleRepository) {
        this.vehiclePhotosRepository = vehiclePhotosRepository;
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public VehiclePhoto createVehiclePhoto(VehiclePhoto vehiclePhoto) {

        VehicleEntity vehicle = vehicleRepository.findById(vehiclePhoto.getVehicle_id())
                .orElseThrow(() -> new NotFoundException(
                        "Veiculo com ID " + vehiclePhoto.getVehicle_id() + " não encontrado"
                ));

        VehiclePhotosEntity saved = vehiclePhotosRepository.save(
                VehiclePhotosEntityMapper.toEntity(vehiclePhoto, vehicle)
        );

        return VehiclePhotosEntityMapper.toDomain(saved);
    }
}
