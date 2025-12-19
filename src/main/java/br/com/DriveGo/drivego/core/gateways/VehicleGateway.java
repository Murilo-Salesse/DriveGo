package br.com.DriveGo.drivego.core.gateways;
import br.com.DriveGo.drivego.core.entities.Vehicle;

import java.util.List;
import java.util.UUID;

public interface VehicleGateway {

    Vehicle createVehicle(Vehicle vehicle);

    Vehicle findById(UUID id);

    Vehicle findByLicensePlate(String licensePlate);

    Vehicle findByVin(String vin);

    Vehicle findByLicensePlateExcludingId(String licensePlate, UUID excludeId);

    Vehicle findByVinExcludingId(String vin, UUID excludeId);

    List<Vehicle> listAllVehicle();

    List<Vehicle> findVehicles(String brand, String model, Short year, String licensePlate, String vin);

    Vehicle updateVehicle(Vehicle vehicle, UUID id);

    Void deleteById(UUID id);
}
