package br.com.DriveGo.drivego.infrastructure.beans;

import br.com.DriveGo.drivego.core.gateways.CategoryGateway;
import br.com.DriveGo.drivego.core.gateways.VehicleGateway;
import br.com.DriveGo.drivego.core.gateways.VehiclePhotoGateway;
import br.com.DriveGo.drivego.core.usecases.categories.*;
import br.com.DriveGo.drivego.core.usecases.vehicles.*;
import br.com.DriveGo.drivego.core.usecases.vehiclesPhotos.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean public CreateCategoryUseCase createCategoryUseCase(CategoryGateway categoryGateway) {
        return new CreateCategoryUseCaseImp(categoryGateway);
    }

    @Bean public FindByIdCategoryUseCase findByIdCategoryUseCase(CategoryGateway categoryGateway) {
        return new FindByIdCategoryUseCaseImp(categoryGateway);
    }

    @Bean public ListAllCategoryUseCase listAllCategoryUseCase(CategoryGateway categoryGateway) {
        return new ListAllCategoryUseCaseImp(categoryGateway);
    }

    @Bean public DeleteCategoryUseCase deleteCategoryUseCase(CategoryGateway categoryGateway) {
        return new DeleteCategoryUseCaseImp(categoryGateway);
    }

    @Bean public UpdateCategoryUseCase updateCategoryUseCase(CategoryGateway categoryGateway) {
        return new UpdateCategoryUseCaseImp(categoryGateway);
    }

    @Bean public ListCategoryByNameUseCase listCategoryByNameUseCase(CategoryGateway categoryGateway) {
        return new ListCategoryByNameUseCaseImp(categoryGateway);
    }


    @Bean public CreateVehicleUseCase createVehicleUseCase(VehicleGateway vehicleGateway) {
        return new CreateVehicleUseCaseImp(vehicleGateway);
    }

    @Bean public ListAllVehiclesUseCase listAllVehiclesUseCase(VehicleGateway vehicleGateway) {
        return new ListAllVehiclesUseCaseImp(vehicleGateway);
    }

    @Bean public FindByIdVehicleUseCase findByIdVehicleUseCase(VehicleGateway vehicleGateway) {
        return new FindByIdVehicleUseCaseImp(vehicleGateway);
    }

    @Bean public FindVehiclesUseCase findVehiclesUseCase(VehicleGateway vehicleGateway) {
        return new FindVehiclesUseCaseImp(vehicleGateway);
    }

    @Bean public UpdateVehicleUseCase updateVehicleUseCase(VehicleGateway vehicleGateway) {
        return new UpdateVehicleUseCaseImp(vehicleGateway);
    }

    @Bean public DeleteVehicleByIdUseCase deleteVehicleByIdUseCase(VehicleGateway vehicleGateway) {
        return new DeleteVehicleByIdUseCaseImp(vehicleGateway);
    }


    @Bean public CreateVehiclePhotoUseCase createVehiclePhotoUseCase(VehiclePhotoGateway vehiclePhotoGateway) {
        return new CreateVehiclePhotoUseCaseImp(vehiclePhotoGateway);
    }

    @Bean public ListAllVehiclePhotosUseCase listAllVehiclePhotosUseCase(VehiclePhotoGateway vehiclePhotoGateway) {
        return new ListAllVehiclePhotosUseCaseImp(vehiclePhotoGateway);
    }

    @Bean public FindByIdVehiclePhotoUseCase findByIdVehiclePhotoUseCase(VehiclePhotoGateway vehiclePhotoGateway) {
        return new FindByIdVehiclePhotoUseCaseImp(vehiclePhotoGateway);
    }

    @Bean public UpdatePhotoVehiclePhotoUseCase updatePhotoVehiclePhotoUseCase(VehiclePhotoGateway vehiclePhotoGateway) {
        return new UpdatePhotoVehiclePhotoUseCaseImp(vehiclePhotoGateway);
    }

    @Bean public DeleteVehiclePhotoByIdUseCase deleteVehiclePhotoByIdUseCase(VehiclePhotoGateway vehiclePhotoGateway) {
        return new DeleteVehiclePhotoByIdUseCaseImp(vehiclePhotoGateway);
    }
}
