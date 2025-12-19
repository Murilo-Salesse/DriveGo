package br.com.DriveGo.drivego.core.usecases.categories;

import br.com.DriveGo.drivego.core.entities.Category;
import br.com.DriveGo.drivego.core.gateways.CategoryGateway;
import br.com.DriveGo.drivego.infrastructure.exceptions.NotFoundException;

import java.util.UUID;

public class FindByIdCategoryUseCaseImp implements FindByIdCategoryUseCase {

    private final CategoryGateway categoryGateway;

    public FindByIdCategoryUseCaseImp(CategoryGateway categoryGateway) {
        this.categoryGateway = categoryGateway;
    }

    @Override
    public Category execute(UUID id) {
        Category category = categoryGateway.findById(id);

        if (category == null) {
            throw new NotFoundException("Categoria não encontrada com ID: " + id);
        }

        return category;
    }
}