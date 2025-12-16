package br.com.DriveGo.drivego.infrastructure.mappers;

import br.com.DriveGo.drivego.core.entities.Vehicle;
import br.com.DriveGo.drivego.core.enums.Status;
import br.com.DriveGo.drivego.infrastructure.dtos.requests.VehicleRequest;
import br.com.DriveGo.drivego.infrastructure.dtos.responses.VehicleResponse;
import lombok.experimental.UtilityClass;
import java.util.List;

@UtilityClass
public class VehicleMapper {

    // Pega a request e transforma em domain (entidade pura)
    public static Vehicle toVehicleDomain(VehicleRequest request) {
        return new Vehicle(
                null,
                request.getLicensePlate(),
                request.getVin(),
                request.getBrand(),
                request.getModel(),
                request.getYear(),
                request.getCategoryId(),
                Status.AVAILABLE,
                request.getMileage(),
                request.getDailyPrice(),
                null,
                null,
                null,
                null,
                null,
                null
        );
    }

    // Ele pega a entidade pura do dominio e transforma em request
    // Mas porque precisa passar para o domain e dps transformar em entity?
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
                v.getUpdated_at()
        );
    }

    // Ele pega a entidade pura do dominio e transforma em lista de request
    public static List<VehicleResponse> toVehicleResponseList(List<Vehicle> vehicles) {
        return vehicles.stream()
                .map(VehicleMapper::toVehicleResponse)
                .toList();
    }
}