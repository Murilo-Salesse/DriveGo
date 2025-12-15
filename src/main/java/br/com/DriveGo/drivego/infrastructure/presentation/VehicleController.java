package br.com.DriveGo.drivego.infrastructure.presentation;

import br.com.DriveGo.drivego.core.entities.Vehicle;
import br.com.DriveGo.drivego.core.usecases.vehicles.*;
import br.com.DriveGo.drivego.infrastructure.dtos.requests.VehicleRequest;
import br.com.DriveGo.drivego.infrastructure.mappers.CategoryMapper;
import br.com.DriveGo.drivego.infrastructure.mappers.VehicleMapper;
import jakarta.validation.Valid;
import lombok.NonNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/vehicle")
public class VehicleController {

    private final CreateVehicleUseCase createVehicleUseCase;
    private final ListAllVehiclesUseCase listAllVehiclesUseCase;
    private final FindByIdVehicleUseCase findByIdVehicleUseCase;
    private final FindVehiclesUseCase findVehiclesUseCase;
    private final DeleteVehicleByIdUseCase deleteVehicleByIdUseCase;

    public VehicleController(CreateVehicleUseCase createVehicleUseCase, ListAllVehiclesUseCase listAllVehiclesUseCase, FindByIdVehicleUseCase findByIdVehicleUseCase, DeleteVehicleByIdUseCase deleteVehicleByIdUseCase, FindVehiclesUseCase findVehiclesUseCase) {
        this.createVehicleUseCase = createVehicleUseCase;
        this.listAllVehiclesUseCase = listAllVehiclesUseCase;
        this.findByIdVehicleUseCase = findByIdVehicleUseCase;
        this.findVehiclesUseCase = findVehiclesUseCase;
        this.deleteVehicleByIdUseCase = deleteVehicleByIdUseCase;
    }

    @PostMapping("/create")
    public ResponseEntity<@NonNull Map<String, Object>> createVehicle(@Valid @RequestBody VehicleRequest request){
        Vehicle newVehicle = createVehicleUseCase.
                execute(VehicleMapper.toVehicleDomain(request));

        Map<String, Object> response = Map.of(
                "message", "Veiculo criado com sucesso.",
                "vehicle", VehicleMapper.toVehicleResponse(newVehicle)
        );

        return ResponseEntity.ok(response);
    }

    @GetMapping("/all")
    public ResponseEntity<@NonNull  Map<String, Object>> listAllCategories(){
        List<Vehicle> vehicles = listAllVehiclesUseCase.listAllVehicle();

        Map<String, Object> response = Map.of(
                "message", "Veiculo(s) listado(s) com sucesso.",
                "vehicle", VehicleMapper.toVehicleResponseList(vehicles)
        );

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<@NonNull Map<String, Object>> findVehicleById(@PathVariable("id")UUID id) {
        Vehicle foundVehicle = findByIdVehicleUseCase.execute(id);

        Map<String, Object> response = Map.of(
                "message", "Veiculo encontrado com sucesso.",
                "vehicle", VehicleMapper.toVehicleResponse(foundVehicle)
        );

        return ResponseEntity.ok(response);
    }

    @GetMapping("/find/")
    public ResponseEntity<?> listVehicles(
            @RequestParam(required = false) String brand,
            @RequestParam(required = false) String model,
            @RequestParam(required = false) Short year,
            @RequestParam(required = false, name = "license_plate") String licensePlate,
            @RequestParam(required = false) String vin
    ) {
        List<Vehicle> foundVehicleList = findVehiclesUseCase.execute(
                brand, model, year, licensePlate, vin);

        Map<String, Object> response = Map.of(
                "message", "Veiculo(s) encontrado(s) com sucesso.",
                "vehicles", VehicleMapper.toVehicleResponseList(foundVehicleList)
        );

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<@NonNull Void> delete(@PathVariable UUID id) {
        deleteVehicleByIdUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
