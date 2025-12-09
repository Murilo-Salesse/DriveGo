package br.com.DriveGo.drivego.core.usecases;

import br.com.DriveGo.drivego.core.entities.Category;
import br.com.DriveGo.drivego.core.gateways.CategoryGateway;

import java.util.List;

public class ListAllCategoryUseCaseImp implements ListAllCategoryUseCase {

    private final CategoryGateway categoryGateway;

    public ListAllCategoryUseCaseImp(CategoryGateway categoryGateway) {
        this.categoryGateway = categoryGateway;
    }


    @Override
    public List<Category> execute() {
        return categoryGateway.getAllCategories();
    }
}
