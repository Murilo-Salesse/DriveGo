package br.com.DriveGo.drivego.infrastructure.mappers;

import br.com.DriveGo.drivego.core.entities.VehiclePhoto;
import br.com.DriveGo.drivego.infrastructure.persistence.VehicleEntity;
import br.com.DriveGo.drivego.infrastructure.persistence.VehiclePhotosEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class VehiclePhotosEntityMapper {

    // Pega o dominio puro e transforma em entidade
    public static VehiclePhotosEntity toEntity(VehiclePhoto vehiclePhoto, VehicleEntity vehicleEntity) {
        VehiclePhotosEntity entity = new VehiclePhotosEntity();

        entity.setId(vehicleEntity.getId());
        entity.setVehicle(vehicleEntity);
        entity.setUrl(vehiclePhoto.getUrl());

        return entity;
    }

    // Pega a entidade e transforma em dominio puro
    public static VehiclePhoto toDomain(VehiclePhotosEntity vehiclePhotosEntity) {

        return new VehiclePhoto(
                vehiclePhotosEntity.getId(),
                vehiclePhotosEntity.getVehicle().getId(),
                vehiclePhotosEntity.getUrl(),
                vehiclePhotosEntity.getUploaded_at()
        );
    }
}
