package br.com.DriveGo.drivego.core.usecases.categories;

import br.com.DriveGo.drivego.core.entities.Category;
import br.com.DriveGo.drivego.core.gateways.CategoryGateway;

import java.util.UUID;

public class UpdateCategoryUseCaseImp implements UpdateCategoryUseCase{

    private final CategoryGateway categoryGateway;

    public UpdateCategoryUseCaseImp(CategoryGateway categoryGateway) {
        this.categoryGateway = categoryGateway;
    }

    @Override
    public Category execute(Category category, UUID id) {
        return categoryGateway.updateCategory(category, id);
    }
}
