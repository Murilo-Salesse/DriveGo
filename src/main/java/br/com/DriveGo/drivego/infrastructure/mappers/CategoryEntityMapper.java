package br.com.DriveGo.drivego.infrastructure.mappers;

import br.com.DriveGo.drivego.core.entities.Category;
import br.com.DriveGo.drivego.infrastructure.persistence.CategoryEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CategoryEntityMapper {

    // Converte de CategoryRequest(entrada) para CategoryEntity (entidade para salvar no banco)
    public static CategoryEntity toEntity(Category category) {
        if (category == null) return null;

        CategoryEntity entity = new CategoryEntity();
        entity.setId(category.getId());
        entity.setName(category.getName());
        entity.setDescription(category.getDescription());
        return entity;
    }

    // Converte de CategoryEntity (entidade do banco) para CategoryResponse (saida)
    public static Category toDomain(CategoryEntity entity) {
        if (entity == null) return null;

        return new Category(
                entity.getId(),
                entity.getName(),
                entity.getDescription()
        );
    }
}