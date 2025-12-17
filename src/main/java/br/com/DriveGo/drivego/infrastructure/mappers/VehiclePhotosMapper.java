package br.com.DriveGo.drivego.infrastructure.mappers;

import br.com.DriveGo.drivego.core.entities.VehiclePhoto;
import br.com.DriveGo.drivego.infrastructure.dtos.requests.VehiclePhotoRequest;
import br.com.DriveGo.drivego.infrastructure.dtos.responses.VehiclePhotoResponse;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.UUID;

@UtilityClass
public class VehiclePhotosMapper {

    // Pega a request e transforma em domain (entidade pura)
    public static VehiclePhoto toDomain(VehiclePhotoRequest request, UUID vehicleId) {

        return new VehiclePhoto(
                null,
                vehicleId,
                request.getUrl(),
                null
        );
    }

    public static VehiclePhoto toDomainForUpdate(VehiclePhotoRequest request) {
        return new VehiclePhoto(
                null,
                null,
                request.getUrl(),
                null
        );
    }

    // Ele pega a entidade pura do dominio e transforma em request
    public static VehiclePhotoResponse toResponse(VehiclePhoto v) {
        return new VehiclePhotoResponse(
                v.getId(),
                v.getUrl(),
                v.getUpdated_at()
        );
    }

    // Ele pega a entidade pura do dominio e transforma em lista de request
    public static List<VehiclePhotoResponse> vehiclePhotoResponseList(List<VehiclePhoto> vehiclePhotos) {
        return vehiclePhotos.stream()
                .map(VehiclePhotosMapper::toResponse)
                .toList();
    }
}
