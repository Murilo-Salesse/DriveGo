package br.com.DriveGo.drivego.core.usecases.categories;
import br.com.DriveGo.drivego.core.entities.Category;
import br.com.DriveGo.drivego.core.gateways.CategoryGateway;

public class CreateCategoryUseCaseImp implements CreateCategoryUseCase {

    private final CategoryGateway categoryGateway;

    public CreateCategoryUseCaseImp(CategoryGateway categoryGateway) {
        this.categoryGateway = categoryGateway;
    }

    @Override
    public Category execute(Category category) {
        return categoryGateway.createCategory(category);
    }
}
