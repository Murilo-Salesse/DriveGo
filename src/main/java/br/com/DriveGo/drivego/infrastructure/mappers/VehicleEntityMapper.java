package br.com.DriveGo.drivego.infrastructure.mappers;

import br.com.DriveGo.drivego.core.entities.Vehicle;
import br.com.DriveGo.drivego.infrastructure.persistence.*;
import lombok.experimental.UtilityClass;

@UtilityClass
public class VehicleEntityMapper {

    // Pega o dominio puro e transforma em entidade
    public static VehicleEntity toEntity(Vehicle domain, CategoryEntity categoryEntity) {
        VehicleEntity entity = new VehicleEntity();

        entity.setId(domain.getId());
        entity.setLicense_plate(domain.getLicense_plate());
        entity.setVin(domain.getVin());
        entity.setBrand(domain.getBrand());
        entity.setModel(domain.getModel());
        entity.setYear(domain.getYear());
        entity.setCategory(categoryEntity);
        entity.setVehicle_status(domain.getStatus());
        entity.setMileage(domain.getMileage());
        entity.setDaily_price(domain.getDaily_price());
        entity.setCreated_at(domain.getCreated_at());
        entity.setUpdated_at(domain.getUpdated_at());

        return entity;
    }

    // Pega a entidade e transforma em dominio puro
    public static Vehicle toDomain(VehicleEntity e) {
        return new Vehicle(
                e.getId(),
                e.getLicense_plate(),
                e.getVin(),
                e.getBrand(),
                e.getModel(),
                e.getYear(),
                e.getCategory().getId(),
                e.getVehicle_status(),
                e.getMileage(),
                e.getDaily_price(),
                e.getCreated_at(),
                e.getUpdated_at(),
                e.getPhotos().stream().map(VehiclePhotosEntity::getId).toList(),
                e.getReservations().stream().map(ReservationEntity::getId).toList(),
                e.getMaintenanceRecords().stream().map(MaintenanceRecordsEntity::getId).toList(),
                e.getDamages().stream().map(DamageEntity::getId).toList()
        );
    }
}