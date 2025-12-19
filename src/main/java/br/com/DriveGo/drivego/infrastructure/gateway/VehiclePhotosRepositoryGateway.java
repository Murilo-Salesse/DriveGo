package br.com.DriveGo.drivego.infrastructure.gateway;

import br.com.DriveGo.drivego.core.entities.VehiclePhoto;
import br.com.DriveGo.drivego.core.gateways.VehiclePhotoGateway;
import br.com.DriveGo.drivego.infrastructure.mappers.VehiclePhotosEntityMapper;
import br.com.DriveGo.drivego.infrastructure.persistence.VehicleEntity;
import br.com.DriveGo.drivego.infrastructure.persistence.VehiclePhotosEntity;
import br.com.DriveGo.drivego.infrastructure.persistence.VehiclePhotosRepository;
import br.com.DriveGo.drivego.infrastructure.persistence.VehicleRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class VehiclePhotosRepositoryGateway implements VehiclePhotoGateway {

    private final VehiclePhotosRepository vehiclePhotosRepository;
    private final VehicleRepository vehicleRepository;

    public VehiclePhotosRepositoryGateway(
            VehiclePhotosRepository vehiclePhotosRepository,
            VehicleRepository vehicleRepository
    ) {
        this.vehiclePhotosRepository = vehiclePhotosRepository;
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public VehiclePhoto createVehiclePhoto(VehiclePhoto vehiclePhoto) {
        VehicleEntity vehicle = vehicleRepository.findById(vehiclePhoto.getVehicle_id())
                .orElseThrow(() -> new RuntimeException(
                        "Veículo não encontrado com ID: " + vehiclePhoto.getVehicle_id()
                ));

        VehiclePhotosEntity saved = vehiclePhotosRepository.save(
                VehiclePhotosEntityMapper.toEntity(vehiclePhoto, vehicle)
        );

        return VehiclePhotosEntityMapper.toDomain(saved);
    }

    @Override
    public VehiclePhoto findById(UUID id) {
        return vehiclePhotosRepository.findById(id)
                .map(VehiclePhotosEntityMapper::toDomain)
                .orElse(null);
    }

    @Override
    public List<VehiclePhoto> listAllPhotosVehicles() {
        return vehiclePhotosRepository.findAll().stream()
                .map(VehiclePhotosEntityMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public VehiclePhoto updatePhoto(VehiclePhoto vehiclePhoto, UUID id) {
        VehiclePhotosEntity foundEntity = vehiclePhotosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Foto não encontrada"));

        foundEntity.setUrl(vehiclePhoto.getUrl());

        VehiclePhotosEntity saved = vehiclePhotosRepository.save(foundEntity);
        return VehiclePhotosEntityMapper.toDomain(saved);
    }

    @Override
    public void deleteById(UUID id) {
        vehiclePhotosRepository.deleteById(id);
    }
}
