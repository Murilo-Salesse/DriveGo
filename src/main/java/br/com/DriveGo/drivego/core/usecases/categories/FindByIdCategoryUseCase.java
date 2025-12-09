package br.com.DriveGo.drivego.core.usecases.categories;
import br.com.DriveGo.drivego.core.entities.Category;

import java.util.UUID;

public interface FindByIdCategoryUseCase {

    Category execute(UUID id);
}
