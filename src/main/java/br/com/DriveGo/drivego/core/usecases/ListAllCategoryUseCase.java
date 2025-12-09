package br.com.DriveGo.drivego.core.usecases;

import br.com.DriveGo.drivego.core.entities.Category;

import java.util.List;

public interface ListAllCategoryUseCase {

    List<Category> execute();
}
