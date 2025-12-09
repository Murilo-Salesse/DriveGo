package br.com.DriveGo.drivego.infrastructure.gateway;

import br.com.DriveGo.drivego.core.entities.Category;
import br.com.DriveGo.drivego.core.gateways.CategoryGateway;
import br.com.DriveGo.drivego.infrastructure.mappers.CategoryEntityMapper;
import br.com.DriveGo.drivego.infrastructure.persistence.CategoryEntity;
import br.com.DriveGo.drivego.infrastructure.persistence.CategoryRepository;
import org.springframework.stereotype.Component;

@Component
public class CategoryRepositoryGateway implements CategoryGateway {

    private final CategoryRepository categoryRepository;

    public CategoryRepositoryGateway(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category createCategory(Category category) {
        CategoryEntity savedEntity = categoryRepository.save(CategoryEntityMapper.toEntity(category));
        return CategoryEntityMapper.toDomain(savedEntity);
    }
}
