package br.com.DriveGo.drivego.core.usecases.categories;
import java.util.UUID;

public interface DeleteCategoryUseCase {

    Void execute(UUID id);
}
