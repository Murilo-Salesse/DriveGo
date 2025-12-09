package br.com.DriveGo.drivego.core.usecases.categories;

import br.com.DriveGo.drivego.core.entities.Category;

import java.util.UUID;

public interface UpdateCategoryUseCase {

    Category execute(Category category, UUID id);
}
