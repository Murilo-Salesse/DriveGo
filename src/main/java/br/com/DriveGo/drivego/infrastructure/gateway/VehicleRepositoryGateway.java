package br.com.DriveGo.drivego.infrastructure.gateway;

import br.com.DriveGo.drivego.core.entities.Vehicle;
import br.com.DriveGo.drivego.core.gateways.VehicleGateway;
import br.com.DriveGo.drivego.infrastructure.exceptions.NotFoundException;
import br.com.DriveGo.drivego.infrastructure.mappers.VehicleEntityMapper;
import br.com.DriveGo.drivego.infrastructure.persistence.CategoryEntity;
import br.com.DriveGo.drivego.infrastructure.persistence.CategoryRepository;
import br.com.DriveGo.drivego.infrastructure.persistence.VehicleEntity;
import br.com.DriveGo.drivego.infrastructure.persistence.VehicleRepository;
import org.springframework.stereotype.Component;

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
        CategoryEntity category = categoryRepository.findById(vehicle.getCategory_id())
                .orElseThrow(() -> new NotFoundException("Categoria não encontrada"));

        VehicleEntity saved = vehicleRepository.save(VehicleEntityMapper.toEntity(vehicle, category));

        return VehicleEntityMapper.toDomain(saved);
    }
}
