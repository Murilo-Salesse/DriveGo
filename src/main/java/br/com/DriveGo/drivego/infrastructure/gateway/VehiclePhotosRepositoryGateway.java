package br.com.DriveGo.drivego.infrastructure.gateway;

import br.com.DriveGo.drivego.core.entities.VehiclePhoto;
import br.com.DriveGo.drivego.core.gateways.VehiclePhotoGateway;
import br.com.DriveGo.drivego.infrastructure.exceptions.NotFoundException;
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

    @Override
    public List<VehiclePhoto> listAllPhotosVehicles() {
        List<VehiclePhotosEntity> vehicleEntityList = vehiclePhotosRepository.findAll();

        return vehicleEntityList.stream()
                .map(VehiclePhotosEntityMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public VehiclePhoto findById(UUID id) {
        VehiclePhotosEntity vehiclePhotos = vehiclePhotosRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Foto(s) não encontrada com ID: " + id));

        return VehiclePhotosEntityMapper.toDomain(vehiclePhotos);
    }

    @Override
    public VehiclePhoto updatePhoto(VehiclePhoto vehiclePhoto, UUID id) {
        VehiclePhotosEntity foundEntity = vehiclePhotosRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Foto(s) não encontrada com ID: " + id));

        foundEntity.setUrl(vehiclePhoto.getUrl());

        VehiclePhotosEntity saved = vehiclePhotosRepository.save(foundEntity);

        return VehiclePhotosEntityMapper.toDomain(saved);
    }

    @Override
    public Void deleteById(UUID id) {
        if (!vehiclePhotosRepository.existsById(id)) {
            throw new NotFoundException("Foto não encontrada");
        }

        vehiclePhotosRepository.deleteById(id);
        return null;
    }
}
