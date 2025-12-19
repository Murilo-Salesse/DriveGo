package br.com.DriveGo.drivego.core.gateways;
import br.com.DriveGo.drivego.core.entities.Category;

import java.util.List;
import java.util.UUID;

public interface CategoryGateway {

    Category createCategory(Category category);
    Category findById(UUID id);
    Category findByName(String name);
    List<Category> getAllCategories();
    List<Category> getCategoryByName(String categoryName);
    Category updateCategory(Category category, UUID id);
    void deleteById(UUID id);
}