package br.com.DriveGo.drivego.infrastructure.presentation;

import br.com.DriveGo.drivego.core.entities.Vehicle;
import br.com.DriveGo.drivego.core.entities.VehiclePhoto;
import br.com.DriveGo.drivego.core.usecases.vehiclesPhotos.*;
import br.com.DriveGo.drivego.infrastructure.dtos.requests.VehiclePhotoRequest;
import br.com.DriveGo.drivego.infrastructure.dtos.requests.VehicleRequest;
import br.com.DriveGo.drivego.infrastructure.mappers.VehicleMapper;
import br.com.DriveGo.drivego.infrastructure.mappers.VehiclePhotosMapper;
import jakarta.validation.Valid;
import lombok.NonNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/vehicle/photos")
public class VehiclePhotosController {

    private final CreateVehiclePhotoUseCase createVehiclePhotoUseCase;
    private final ListAllVehiclePhotosUseCase listAllVehiclePhotosUseCase;
    private final FindByIdVehiclePhotoUseCase findByIdVehiclePhotoUseCase;
    private final UpdatePhotoVehiclePhotoUseCase updatePhotoVehiclePhotoUseCase;
    private final DeleteVehiclePhotoByIdUseCase deleteVehiclePhotoByIdUseCase;

    public VehiclePhotosController(CreateVehiclePhotoUseCase createVehiclePhotoUseCase, ListAllVehiclePhotosUseCase listAllVehiclePhotosUseCase, FindByIdVehiclePhotoUseCase findByIdVehiclePhotoUseCase, UpdatePhotoVehiclePhotoUseCase updatePhotoVehiclePhotoUseCase, DeleteVehiclePhotoByIdUseCase deleteVehiclePhotoByIdUseCase) {
        this.createVehiclePhotoUseCase = createVehiclePhotoUseCase;
        this.listAllVehiclePhotosUseCase = listAllVehiclePhotosUseCase;
        this.findByIdVehiclePhotoUseCase = findByIdVehiclePhotoUseCase;
        this.updatePhotoVehiclePhotoUseCase = updatePhotoVehiclePhotoUseCase;
        this.deleteVehiclePhotoByIdUseCase = deleteVehiclePhotoByIdUseCase;
    }

    @PostMapping("/create/{vehicleId}")
    public ResponseEntity<@NonNull Map<String, Object>> createVehiclePhoto(@Valid @RequestBody VehiclePhotoRequest request,
                                                                           @PathVariable UUID vehicleId){
        VehiclePhoto newVehiclePhoto = createVehiclePhotoUseCase.execute(
                VehiclePhotosMapper.toDomain(request, vehicleId)
        );

        Map<String, Object> data = Map.of(
                "message", "Foto criada com sucesso.",
                "photo", VehiclePhotosMapper.toResponse(newVehiclePhoto)
        );

        return ResponseEntity.ok(Map.of("data", data));
    }

    @GetMapping("/all")
    public ResponseEntity<@NonNull  Map<String, Object>> listAllVehiclesPhotos(){
        List<VehiclePhoto> vehiclesPhotos = listAllVehiclePhotosUseCase.execute();

        Map<String, Object> data = Map.of(
                "message", "Foto(s) listada(s) com sucesso.",
                "photo", VehiclePhotosMapper.vehiclePhotoResponseList(vehiclesPhotos)
        );

        return ResponseEntity.ok(Map.of("data", data));
    }

    @GetMapping("/{id}")
    public ResponseEntity<@NonNull Map<String, Object>> findVehicleById(@PathVariable("id")UUID id){
        VehiclePhoto foundVehiclePhoto = findByIdVehiclePhotoUseCase.execute(id);

        Map<String, Object> data = Map.of(
                "message", "Foto(s) encontrada(s) com sucesso.",
                "photo", VehiclePhotosMapper.toResponse(foundVehiclePhoto)
        );

        return ResponseEntity.ok(Map.of("data", data));
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<@NonNull Map<String, Object>> updateVehiclePhoto(@Valid @RequestBody VehiclePhotoRequest request,
                                                                           @PathVariable("id") UUID id) {
        VehiclePhoto updatedVehiclePhoto = updatePhotoVehiclePhotoUseCase.execute(VehiclePhotosMapper.toDomainForUpdate(request), id);

        Map<String, Object> data = Map.of(
                "message", "Veiculo atualizado com sucesso.",
                "photo", VehiclePhotosMapper.toResponse(updatedVehiclePhoto)
        );

        return ResponseEntity.ok(Map.of("data", data));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<@NonNull Map<String, Object>> delete(@PathVariable UUID id) {
        deleteVehiclePhotoByIdUseCase.execute(id);

        Map<String, Object> data = Map.of(
                "message", "Foto deletada com sucesso."
        );

        return ResponseEntity.ok(Map.of("data", data));
    }
}