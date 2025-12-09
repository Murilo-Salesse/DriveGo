package br.com.DriveGo.drivego.infrastructure.mappers;

import br.com.DriveGo.drivego.core.entities.Category;
import br.com.DriveGo.drivego.infrastructure.dtos.requests.CategoryRequest;
import br.com.DriveGo.drivego.infrastructure.dtos.responses.CategoryResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CategoryMapper {

    // Converte de CategoryDTO (entrada) para EntityModel (entidade do banco)
    public static Category toCategoryEntity(CategoryRequest categoryRequest) {

        return new Category(
                null,
                categoryRequest.getName(),
                categoryRequest.getDescription()
        );
    }

    // Converte de EntityModel (entidade do banco) para EntityDTO (saida)
    public static CategoryResponse toCategoryRequest(Category category) {

        return new CategoryResponse(
                category.getId(),
                category.getName(),
                category.getDescription()
        );
    }
}
