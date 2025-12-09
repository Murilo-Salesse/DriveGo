package br.com.DriveGo.drivego.core.usecases.categories;

import br.com.DriveGo.drivego.core.gateways.CategoryGateway;

import java.util.UUID;

public class DeleteCategoryUseCaseImp implements DeleteCategoryUseCase{

    private final CategoryGateway categoryGateway;

    public DeleteCategoryUseCaseImp(CategoryGateway categoryGateway) {
        this.categoryGateway = categoryGateway;
    }

    @Override
    public Void execute(UUID id) {
        return categoryGateway.deleteById(id);
    }
}
