package br.com.DriveGo.drivego.infrastructure.mappers;

import br.com.DriveGo.drivego.core.entities.Vehicle;
import br.com.DriveGo.drivego.infrastructure.persistence.*;
import lombok.experimental.UtilityClass;

@UtilityClass
public class VehicleEntityMapper {

    // Pega o dominio puro e transforma em entidade
    public static VehicleEntity toEntity(Vehicle vehicle, CategoryEntity category) {
        VehicleEntity entity = new VehicleEntity();

        entity.setId(vehicle.getId());
        entity.setLicensePlate(vehicle.getLicense_plate());
        entity.setVin(vehicle.getVin());
        entity.setBrand(vehicle.getBrand());
        entity.setModel(vehicle.getModel());
        entity.setYear(vehicle.getYear());
        entity.setCategory(category);
        entity.setVehicleStatus(vehicle.getStatus());
        entity.setMileage(vehicle.getMileage());
        entity.setDailyPrice(vehicle.getDaily_price());
        entity.setCreatedAt(vehicle.getCreated_at());
        entity.setUpdatedAt(vehicle.getUpdated_at());

        return entity;
    }


    // Pega a entidade e transforma em dominio puro
    public static Vehicle toDomain(VehicleEntity entity) {
        return new Vehicle(
                entity.getId(),
                entity.getLicensePlate(),  // Entity usa camelCase
                entity.getVin(),
                entity.getBrand(),
                entity.getModel(),
                entity.getYear(),
                entity.getCategory() != null ? entity.getCategory().getId() : null,
                entity.getVehicleStatus(),
                entity.getMileage(),
                entity.getDailyPrice(),  // Entity usa camelCase
                entity.getCreatedAt(),
                entity.getUpdatedAt(),
                entity.getPhotos().stream().map(VehiclePhotosEntity::getId).toList(),
                entity.getReservations().stream().map(ReservationEntity::getId).toList(),
                entity.getMaintenanceRecords().stream().map(MaintenanceRecordsEntity::getId).toList(),
                entity.getDamages().stream().map(DamageEntity::getId).toList()
        );
    }
}