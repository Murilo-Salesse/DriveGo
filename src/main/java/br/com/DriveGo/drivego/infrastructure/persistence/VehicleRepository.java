package br.com.DriveGo.drivego.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface VehicleRepository extends JpaRepository<VehicleEntity, UUID> {

    @Query(value = """
        SELECT *
        FROM vehicles v
        WHERE (:brand IS NULL OR v.brand ILIKE CONCAT('%', CAST(:brand AS TEXT), '%'))
          AND (:model IS NULL OR v.model ILIKE CONCAT('%', CAST(:model AS TEXT), '%'))
          AND (:year IS NULL OR v.year = :year)
          AND (:licensePlate IS NULL OR v.license_plate ILIKE CONCAT('%', CAST(:licensePlate AS TEXT), '%'))
          AND (:vin IS NULL OR v.vin ILIKE CONCAT('%', CAST(:vin AS TEXT), '%'))
""", nativeQuery = true)
    List<VehicleEntity> findVehiclesByFilters(
            @Param("brand") String brand,
            @Param("model") String model,
            @Param("year") Short year,
            @Param("licensePlate") String licensePlate,
            @Param("vin") String vin
    );

    Optional<VehicleEntity> findByLicensePlate(String licensePlate);
    Optional<VehicleEntity> findByVin(String vin);

    Optional<VehicleEntity> findByLicensePlateAndIdNot(String licensePlate, UUID id);
    Optional<VehicleEntity> findByVinAndIdNot(String vin, UUID id);
}
