package br.com.DriveGo.drivego.infrastructure.presentation;

import br.com.DriveGo.drivego.core.entities.Vehicle;
import br.com.DriveGo.drivego.core.usecases.vehicles.*;
import br.com.DriveGo.drivego.infrastructure.dtos.requests.VehicleRequest;
import br.com.DriveGo.drivego.infrastructure.mappers.VehicleMapper;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
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
    private final UpdateVehicleUseCase updateVehicleUseCase;
    private final DeleteVehicleByIdUseCase deleteVehicleByIdUseCase;

    public VehicleController(CreateVehicleUseCase createVehicleUseCase,
                             ListAllVehiclesUseCase listAllVehiclesUseCase,
                             FindByIdVehicleUseCase findByIdVehicleUseCase,
                             DeleteVehicleByIdUseCase deleteVehicleByIdUseCase,
                             FindVehiclesUseCase findVehiclesUseCase,
                             UpdateVehicleUseCase updateVehicleUseCase) {
        this.createVehicleUseCase = createVehicleUseCase;
        this.listAllVehiclesUseCase = listAllVehiclesUseCase;
        this.findByIdVehicleUseCase = findByIdVehicleUseCase;
        this.findVehiclesUseCase = findVehiclesUseCase;
        this.deleteVehicleByIdUseCase = deleteVehicleByIdUseCase;
        this.updateVehicleUseCase = updateVehicleUseCase;
    }

    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> createVehicle(
            @Valid @RequestBody VehicleRequest request) {

        Vehicle newVehicle = createVehicleUseCase.execute(
                VehicleMapper.toVehicleDomain(request));

        Map<String, Object> data = Map.of(
                "message", "Veículo criado com sucesso.",
                "vehicle", VehicleMapper.toVehicleResponse(newVehicle)
        );

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("data", data));
    }

    @GetMapping("/all")
    public ResponseEntity<Map<String, Object>> listAllVehicles() {
        List<Vehicle> vehicles = listAllVehiclesUseCase.listAllVehicle();

        Map<String, Object> data = Map.of(
                "message", "Veículo(s) listado(s) com sucesso.",
                "vehicles", VehicleMapper.toVehicleResponseList(vehicles)
        );

        return ResponseEntity.ok(Map.of("data", data));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> findVehicleById(
            @PathVariable("id") UUID id) {

        Vehicle foundVehicle = findByIdVehicleUseCase.execute(id);

        Map<String, Object> data = Map.of(
                "message", "Veículo encontrado com sucesso.",
                "vehicle", VehicleMapper.toVehicleResponse(foundVehicle)
        );

        return ResponseEntity.ok(Map.of("data", data));
    }

    @GetMapping("/find/")
    public ResponseEntity<Map<String, Object>> listVehicles(
            @RequestParam(required = false) String brand,
            @RequestParam(required = false) String model,
            @RequestParam(required = false) Short year,
            @RequestParam(required = false, name = "license_plate") String licensePlate,
            @RequestParam(required = false) String vin
    ) {
        List<Vehicle> foundVehicleList = findVehiclesUseCase.execute(
                brand, model, year, licensePlate, vin);

        Map<String, Object> data = Map.of(
                "message", "Veículo(s) encontrado(s) com sucesso.",
                "vehicles", VehicleMapper.toVehicleResponseList(foundVehicleList)
        );

        return ResponseEntity.ok(Map.of("data", data));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateVehicle(
            @Valid @RequestBody VehicleRequest request,
            @PathVariable("id") UUID id) {

        Vehicle updatedVehicle = updateVehicleUseCase.execute(
                VehicleMapper.toVehicleDomain(request), id);

        Map<String, Object> data = Map.of(
                "message", "Veículo atualizado com sucesso.",
                "vehicle", VehicleMapper.toVehicleResponse(updatedVehicle)
        );

        return ResponseEntity.ok(Map.of("data", data));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable UUID id) {
        deleteVehicleByIdUseCase.execute(id);

        Map<String, Object> data = Map.of(
                "message", "Veículo deletado com sucesso."
        );

        return ResponseEntity.ok(Map.of("data", data));
    }
}