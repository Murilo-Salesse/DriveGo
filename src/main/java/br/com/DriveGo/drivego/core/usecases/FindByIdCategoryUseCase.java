package br.com.DriveGo.drivego.core.usecases;
import br.com.DriveGo.drivego.core.entities.Category;

import java.util.UUID;

public interface FindByIdCategoryUseCase {

    Category execute(UUID id);
}
