package br.com.DriveGo.drivego.core.usecases.categories;

import br.com.DriveGo.drivego.core.entities.Category;
import br.com.DriveGo.drivego.core.gateways.CategoryGateway;

import java.util.List;

public class ListCategoryByNameUseCaseImp implements ListCategoryByNameUseCase{

    private final CategoryGateway categoryGateway;

    public ListCategoryByNameUseCaseImp(CategoryGateway categoryGateway) {
        this.categoryGateway = categoryGateway;
    }

    @Override
    public List<Category> execute(String categoryName) {
        return categoryGateway.getCategoryByName(categoryName);
    }
}
