package br.com.DriveGo.drivego.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CategoryRepository extends JpaRepository<CategoryEntity, UUID> {


    Optional<CategoryEntity> findByNameIgnoreCase(String name);
    List<CategoryEntity> findCategoryByNameContainingIgnoreCase(String categoryName);

}
