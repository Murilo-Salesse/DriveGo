package br.com.DriveGo.drivego.infrastructure.mappers;

import br.com.DriveGo.drivego.core.entities.Category;
import br.com.DriveGo.drivego.infrastructure.dtos.requests.CategoryRequest;
import br.com.DriveGo.drivego.infrastructure.dtos.responses.CategoryResponse;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class CategoryMapper {

    // Converte de CategoryRequest (entrada) para EntityModel (entidade do pura do core)
    public static Category toCategoryEntity(CategoryRequest categoryRequest) {

        return new Category(
                null,
                categoryRequest.getName(),
                categoryRequest.getDescription()
        );
    }

    // Converte de EntityModel (entidade do banco) para CategoryResponse (saida)
    public static CategoryResponse toCategoryRequest(Category category) {

        return new CategoryResponse(
                category.getId(),
                category.getName(),
                category.getDescription()
        );
    }

    public static List<CategoryResponse> toCategoryRequestList(List<Category> categories) {
        return categories.stream()
                .map(CategoryMapper::toCategoryRequest)
                .toList();
    }
}
