package br.com.DriveGo.drivego.core.usecases.categories;

import br.com.DriveGo.drivego.core.entities.Category;
import br.com.DriveGo.drivego.core.gateways.CategoryGateway;
import br.com.DriveGo.drivego.core.exceptions.DuplicateException;
import br.com.DriveGo.drivego.core.exceptions.NotFoundException;

import java.util.UUID;

public class UpdateCategoryUseCaseImp implements UpdateCategoryUseCase {

    private final CategoryGateway categoryGateway;

    public UpdateCategoryUseCaseImp(CategoryGateway categoryGateway) {
        this.categoryGateway = categoryGateway;
    }

    @Override
    public Category execute(Category category, UUID id) {
        validateCategoryExists(id);
        validateUniqueNameExcludingCurrent(category.getName(), id);
        return categoryGateway.updateCategory(category, id);
    }

    private void validateCategoryExists(UUID id) {
        Category existing = categoryGateway.findById(id);
        if (existing == null) {
            throw new NotFoundException("Categoria não encontrada com ID: " + id);
        }
    }

    private void validateUniqueNameExcludingCurrent(String name, UUID currentId) {
        Category existing = categoryGateway.findByName(name);

        // Se existe uma categoria com esse nome E não é a categoria atual sendo atualizada
        if (existing != null && !existing.getId().equals(currentId)) {
            throw new DuplicateException(
                    "Categoria com nome '" + name + "' já existe"
            );
        }
    }
}
