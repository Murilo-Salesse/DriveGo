package br.com.DriveGo.drivego.core.usecases.vehicles;

import br.com.DriveGo.drivego.core.entities.Vehicle;

import java.util.List;

public interface FindVehiclesUseCase {

    List<Vehicle> execute(
            String brand,
            String model,
            Short year,
            String licensePlate,
            String vin
    );
}
