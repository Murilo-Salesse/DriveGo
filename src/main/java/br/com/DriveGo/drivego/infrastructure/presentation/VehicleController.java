package br.com.DriveGo.drivego.infrastructure.presentation;

import br.com.DriveGo.drivego.core.entities.Vehicle;
import br.com.DriveGo.drivego.core.usecases.vehicles.CreateVehicleUseCase;
import br.com.DriveGo.drivego.infrastructure.dtos.requests.VehicleRequest;
import br.com.DriveGo.drivego.infrastructure.mappers.VehicleMapper;
import jakarta.validation.Valid;
import lombok.NonNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/vehicle")
public class VehicleController {

    private final CreateVehicleUseCase createVehicleUseCase;

    public VehicleController(CreateVehicleUseCase createVehicleUseCase) {
        this.createVehicleUseCase = createVehicleUseCase;
    }

    @PostMapping("/create")
    public ResponseEntity<@NonNull Map<String, Object>> createVehicle(@Valid @RequestBody VehicleRequest request){
        Vehicle newVehicle = createVehicleUseCase.execute(VehicleMapper.toVehicleDomain(request));

        Map<String, Object> response = Map.of(
                "message", "Veiculo criado com sucesso.",
                "vehicle", VehicleMapper.toVehicleResponse(newVehicle)
        );

        return ResponseEntity.ok(response);
    }

}
