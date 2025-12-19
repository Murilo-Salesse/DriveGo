package br.com.DriveGo.drivego.core.usecases.categories;

import br.com.DriveGo.drivego.core.gateways.CategoryGateway;
import br.com.DriveGo.drivego.infrastructure.exceptions.NotFoundException;

import java.util.UUID;

public class DeleteCategoryUseCaseImp implements DeleteCategoryUseCase {

    private final CategoryGateway categoryGateway;

    public DeleteCategoryUseCaseImp(CategoryGateway categoryGateway) {
        this.categoryGateway = categoryGateway;
    }

    @Override
    public Void execute(UUID id) {
        validateCategoryExists(id);
        categoryGateway.deleteById(id);
        return null;
    }

    private void validateCategoryExists(UUID id) {
        if (categoryGateway.findById(id) == null) {
            throw new NotFoundException("Categoria não encontrada com ID: " + id);
        }
    }
}
