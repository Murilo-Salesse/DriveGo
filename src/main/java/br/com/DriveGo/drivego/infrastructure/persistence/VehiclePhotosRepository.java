package br.com.DriveGo.drivego.infrastructure.persistence;

import br.com.DriveGo.drivego.core.entities.VehiclePhoto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VehiclePhotosRepository extends JpaRepository<VehiclePhotosEntity, UUID> {
}
