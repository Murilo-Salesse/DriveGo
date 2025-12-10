package br.com.DriveGo.drivego.core.usecases.categories;

import br.com.DriveGo.drivego.core.entities.Category;

import java.util.List;

public interface ListCategoryByNameUseCase {

    List<Category> execute(String categoryName);
}
