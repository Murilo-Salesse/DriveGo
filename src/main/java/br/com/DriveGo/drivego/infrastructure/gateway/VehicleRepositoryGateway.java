package br.com.DriveGo.drivego.infrastructure.gateway;

import br.com.DriveGo.drivego.core.entities.Vehicle;
import br.com.DriveGo.drivego.core.gateways.VehicleGateway;
import br.com.DriveGo.drivego.infrastructure.exceptions.DuplicateException;
import br.com.DriveGo.drivego.infrastructure.exceptions.NotFoundException;
import br.com.DriveGo.drivego.infrastructure.mappers.VehicleEntityMapper;
import br.com.DriveGo.drivego.infrastructure.persistence.CategoryEntity;
import br.com.DriveGo.drivego.infrastructure.persistence.CategoryRepository;
import br.com.DriveGo.drivego.infrastructure.persistence.VehicleEntity;
import br.com.DriveGo.drivego.infrastructure.persistence.VehicleRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class VehicleRepositoryGateway implements VehicleGateway {

    private final VehicleRepository vehicleRepository;
    private final CategoryRepository categoryRepository;

    public VehicleRepositoryGateway(VehicleRepository vehicleRepository, CategoryRepository categoryRepository) {
        this.vehicleRepository = vehicleRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Vehicle createVehicle(Vehicle vehicle) {

        Optional<VehicleEntity> foundWithPlate = vehicleRepository.findByLicensePlate(vehicle.getLicense_plate());
        Optional<VehicleEntity> foundWithVin = vehicleRepository.findByVin(vehicle.getVin());

        if (foundWithPlate.isPresent() && foundWithVin.isPresent()) {
            throw new DuplicateException(
                    "Veículo com placa " + vehicle.getLicense_plate() +
                            " e VIN " + vehicle.getVin() + " já estão cadastrados"
            );
        }
        if (foundWithPlate.isPresent()) {
            throw new DuplicateException(
                    "Veículo com placa " + vehicle.getLicense_plate() + " já está cadastrado"
            );
        }
        if (foundWithVin.isPresent()) {
            throw new DuplicateException(
                    "Veículo com VIN " + vehicle.getVin() + " já está cadastrado"
            );
        }

        CategoryEntity category = categoryRepository.findById(vehicle.getCategory_id())
                .orElseThrow(() -> new NotFoundException(
                        "Categoria com ID " + vehicle.getCategory_id() + " não encontrada"
                ));

        VehicleEntity saved = vehicleRepository.save(
                VehicleEntityMapper.toEntity(vehicle, category)
        );

        return VehicleEntityMapper.toDomain(saved);
    }

    @Override
    public List<Vehicle> listAllVehicle() {
        List<VehicleEntity> vehicleEntities = vehicleRepository.findAll();

        return vehicleEntities.stream()
                .map(VehicleEntityMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Vehicle> findVehicles(String brand, String model, Short year, String licensePlate, String vin) {
        List<VehicleEntity> vehicleEntityList = vehicleRepository.findVehiclesByFilters(
                brand, model, year, licensePlate, vin);

        return vehicleEntityList.stream()
                .map(VehicleEntityMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Vehicle findById(UUID id) {
        VehicleEntity vehicleFound = vehicleRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Veiculo não encontrado com ID: " + id));

        return VehicleEntityMapper.toDomain(vehicleFound);
    }

    @Override
    public Void deleteById(UUID id) {
        if (!vehicleRepository.existsById(id)) {
            throw new NotFoundException("Veiculo não encontrada");
        }

        vehicleRepository.deleteById(id);
        return null;
    }
}
