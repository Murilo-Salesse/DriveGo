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

import java.util.List;
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
    public Vehicle findById(UUID id) {
        return vehicleRepository.findById(id)
                .map(VehicleEntityMapper::toDomain)
                .orElse(null);
    }

    @Override
    public Vehicle findByLicensePlate(String licensePlate) {
        return vehicleRepository.findByLicensePlate(licensePlate)
                .map(VehicleEntityMapper::toDomain)
                .orElse(null);
    }

    @Override
    public Vehicle findByVin(String vin) {
        return vehicleRepository.findByVin(vin)
                .map(VehicleEntityMapper::toDomain)
                .orElse(null);
    }

    @Override
    public Vehicle findByLicensePlateExcludingId(String licensePlate, UUID excludeId) {
        return vehicleRepository.findByLicensePlateAndIdNot(licensePlate, excludeId)
                .map(VehicleEntityMapper::toDomain)
                .orElse(null);
    }

    @Override
    public Vehicle findByVinExcludingId(String vin, UUID excludeId) {
        return vehicleRepository.findByVinAndIdNot(vin, excludeId)
                .map(VehicleEntityMapper::toDomain)
                .orElse(null);
    }

    @Override
    public List<Vehicle> listAllVehicle() {
        return vehicleRepository.findAll().stream()
                .map(VehicleEntityMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Vehicle> findVehicles(String brand, String model, Short year, String licensePlate, String vin) {
        return vehicleRepository.findVehiclesByFilters(brand, model, year, licensePlate, vin).stream()
                .map(VehicleEntityMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Vehicle updateVehicle(Vehicle vehicle, UUID id) {
        VehicleEntity vehicleFound = vehicleRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Veículo não encontrado com ID: " + id));

        CategoryEntity category = categoryRepository.findById(vehicle.getCategory_id())
                .orElseThrow(() -> new NotFoundException(
                        "Categoria não encontrada com ID: " + vehicle.getCategory_id()
                ));

        vehicleFound.setLicensePlate(vehicle.getLicense_plate());
        vehicleFound.setVin(vehicle.getVin());
        vehicleFound.setBrand(vehicle.getBrand());
        vehicleFound.setModel(vehicle.getModel());
        vehicleFound.setYear(vehicle.getYear());
        vehicleFound.setCategory(category);
        vehicleFound.setMileage(vehicle.getMileage());
        vehicleFound.setDailyPrice(vehicle.getDaily_price());

        VehicleEntity saved = vehicleRepository.save(vehicleFound);
        return VehicleEntityMapper.toDomain(saved);
    }

    @Override
    public Void deleteById(UUID id) {
        if (!vehicleRepository.existsById(id)) {
            throw new NotFoundException("Veículo não encontrado");
        }
        vehicleRepository.deleteById(id);
        return null;
    }
}
