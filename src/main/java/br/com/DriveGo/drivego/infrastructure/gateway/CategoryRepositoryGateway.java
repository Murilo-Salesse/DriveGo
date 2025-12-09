package br.com.DriveGo.drivego.infrastructure.gateway;

import br.com.DriveGo.drivego.core.entities.Category;
import br.com.DriveGo.drivego.core.gateways.CategoryGateway;
import br.com.DriveGo.drivego.infrastructure.exceptions.NotFoundException;
import br.com.DriveGo.drivego.infrastructure.mappers.CategoryEntityMapper;
import br.com.DriveGo.drivego.infrastructure.persistence.CategoryEntity;
import br.com.DriveGo.drivego.infrastructure.persistence.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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

    @Override
    public List<Category> getAllCategories() {
        List<CategoryEntity> categoryList = categoryRepository.findAll();

        return categoryList.stream()
                .map(CategoryEntityMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Category> getCategoryByName(String categoryName) {
        return List.of();
    }

    @Override
    public Category findById(UUID id) {
        CategoryEntity entity = categoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Categoria não encontrada com o ID " + id));

        return CategoryEntityMapper.toDomain(entity);
    }

    @Override
    public Category updateCategory(Category category, UUID id) {
        CategoryEntity foundEntity = categoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Categoria não encontrada com o ID " + id));

        foundEntity.setName(category.getName());
        foundEntity.setDescription(category.getDescription());

        CategoryEntity saved = categoryRepository.save(foundEntity);

        return CategoryEntityMapper.toDomain(saved);
    }

    @Override
    public Void deleteById(UUID id) {
        if (!categoryRepository.existsById(id)) {
            throw new NotFoundException("Categoria não encontrada");
        }

        categoryRepository.deleteById(id);
        return null;
    }
}
