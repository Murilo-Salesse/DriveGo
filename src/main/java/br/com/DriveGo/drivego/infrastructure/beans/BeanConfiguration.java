package br.com.DriveGo.drivego.infrastructure.beans;

import br.com.DriveGo.drivego.core.gateways.CategoryGateway;
import br.com.DriveGo.drivego.core.usecases.categories.*;
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

}
