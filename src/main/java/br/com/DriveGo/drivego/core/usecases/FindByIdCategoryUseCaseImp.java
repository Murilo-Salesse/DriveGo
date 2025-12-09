package br.com.DriveGo.drivego.core.usecases;

import br.com.DriveGo.drivego.core.entities.Category;
import br.com.DriveGo.drivego.core.gateways.CategoryGateway;

import java.util.UUID;

public class FindByIdCategoryUseCaseImp implements FindByIdCategoryUseCase {

    private final CategoryGateway categoryGateway;

    public FindByIdCategoryUseCaseImp(CategoryGateway categoryGateway) {
        this.categoryGateway = categoryGateway;
    }

    @Override
    public Category execute(UUID id) {
        return categoryGateway.findById(id);
    }

}
