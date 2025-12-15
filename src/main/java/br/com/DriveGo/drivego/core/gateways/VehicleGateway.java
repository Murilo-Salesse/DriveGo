package br.com.DriveGo.drivego.core.gateways;
import br.com.DriveGo.drivego.core.entities.Vehicle;

import java.util.List;
import java.util.UUID;

public interface VehicleGateway {

    Vehicle createVehicle(Vehicle vehicle);
    List<Vehicle> listAllVehicle();
    List<Vehicle> findVehicles(
            String brand,
            String model,
            Short year,
            String licensePlate,
            String vin
    );
    Vehicle findById(UUID id);
    Void deleteById(UUID id);
}
