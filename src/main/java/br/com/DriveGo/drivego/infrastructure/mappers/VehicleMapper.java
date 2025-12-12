package br.com.DriveGo.drivego.infrastructure.mappers;

import br.com.DriveGo.drivego.core.entities.Vehicle;
import br.com.DriveGo.drivego.core.enums.Status;
import br.com.DriveGo.drivego.infrastructure.dtos.requests.VehicleRequest;
import br.com.DriveGo.drivego.infrastructure.dtos.responses.VehicleResponse;
import lombok.experimental.UtilityClass;

import java.math.BigDecimal;
import java.util.List;

@UtilityClass
public class VehicleMapper {

    // Request → Domain
    public static Vehicle toVehicleDomain(VehicleRequest request) {
        return new Vehicle(
                null,                                    // id
                request.getPlate(),                         // license_plate
                request.getVin(),                           // vin (ANTES ESTAVA NULL)
                request.getBrand(),
                request.getModel(),
                request.getYear().shortValue(),
                request.getCategory_id(),
                Status.AVAILABLE,                           // status inicial
                request.getMileage(),                       // mileage (ANTES ESTAVA 0)
                BigDecimal.valueOf(request.getDaily_price()),
                null,                              // created_at
                null,                                       // updated_at
                null,
                null,
                null,
                null
        );
    }

    // Domain → Response
    public static VehicleResponse toVehicleResponse(Vehicle v) {
        return new VehicleResponse(
                v.getId(),
                v.getLicense_plate(),
                v.getVin(),
                v.getBrand(),
                v.getModel(),
                v.getYear(),
                v.getCategory_id(),
                v.getStatus() != null ? v.getStatus().name() : null,
                v.getMileage(),
                v.getDaily_price(),
                v.getCreated_at(),
                v.getUpdated_at(),
                v.getPhotoIds(),
                v.getReservationIds(),
                v.getMaintenanceRecordIds(),
                v.getDamageIds()
        );
    }

    public static List<VehicleResponse> toVehicleResponseList(List<Vehicle> vehicles) {
        return vehicles.stream()
                .map(VehicleMapper::toVehicleResponse)
                .toList();
    }
}