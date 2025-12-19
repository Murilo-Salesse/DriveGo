package br.com.DriveGo.drivego.infrastructure.gateway;

import br.com.DriveGo.drivego.core.entities.Category;
import br.com.DriveGo.drivego.core.gateways.CategoryGateway;
import br.com.DriveGo.drivego.infrastructure.mappers.CategoryEntityMapper;
import br.com.DriveGo.drivego.infrastructure.persistence.CategoryEntity;
import br.com.DriveGo.drivego.infrastructure.persistence.CategoryRepository;
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
        CategoryEntity savedEntity = categoryRepository.save(
                CategoryEntityMapper.toEntity(category)
        );
        return CategoryEntityMapper.toDomain(savedEntity);
    }

    @Override
    public Category findById(UUID id) {
        return categoryRepository.findById(id)
                .map(CategoryEntityMapper::toDomain)
                .orElse(null);
    }

    @Override
    public Category findByName(String name) {
        return categoryRepository.findByNameIgnoreCase(name)
                .map(CategoryEntityMapper::toDomain)
                .orElse(null);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll().stream()
                .map(CategoryEntityMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Category> getCategoryByName(String categoryName) {
        return categoryRepository.findCategoryByNameContainingIgnoreCase(categoryName).stream()
                .map(CategoryEntityMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Category updateCategory(Category category, UUID id) {
        CategoryEntity foundEntity = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        foundEntity.setName(category.getName());
        foundEntity.setDescription(category.getDescription());

        CategoryEntity saved = categoryRepository.save(foundEntity);
        return CategoryEntityMapper.toDomain(saved);
    }

    @Override
    public void deleteById(UUID id) {
        categoryRepository.deleteById(id);
    }
}
