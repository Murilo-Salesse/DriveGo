package br.com.DriveGo.drivego.core.usecases.categories;
import br.com.DriveGo.drivego.core.entities.Category;
import br.com.DriveGo.drivego.core.gateways.CategoryGateway;
import br.com.DriveGo.drivego.core.exceptions.DuplicateException;

public class CreateCategoryUseCaseImp implements CreateCategoryUseCase {

    private final CategoryGateway categoryGateway;

    public CreateCategoryUseCaseImp(CategoryGateway categoryGateway) {
        this.categoryGateway = categoryGateway;
    }

    @Override
    public Category execute(Category category) {
        validateUniqueName(category.getName());
        return categoryGateway.createCategory(category);
    }

    private void validateUniqueName(String name) {
        Category existing = categoryGateway.findByName(name);
        if (existing != null) {
            throw new DuplicateException(
                    "Categoria com nome '" + name + "' já existe"
            );
        }
    }
}