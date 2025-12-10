package br.com.DriveGo.drivego.infrastructure.presentation;

import br.com.DriveGo.drivego.core.entities.Category;
import br.com.DriveGo.drivego.core.usecases.categories.*;
import br.com.DriveGo.drivego.infrastructure.dtos.requests.CategoryRequest;
import br.com.DriveGo.drivego.infrastructure.mappers.CategoryMapper;
import jakarta.validation.Valid;
import lombok.NonNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private final CreateCategoryUseCase createCategoryUseCase;
    private final FindByIdCategoryUseCase findByIdCategoryUseCase;
    private final ListAllCategoryUseCase listAllCategoryUseCase;
    private final DeleteCategoryUseCase deleteCategoryUseCase;
    private final UpdateCategoryUseCase updateCategoryUseCase;
    private final ListCategoryByNameUseCase listCategoryByNameUseCase;

    public CategoryController(CreateCategoryUseCase createCategoryUseCase, FindByIdCategoryUseCase findByIdCategoryUseCase, ListAllCategoryUseCase listAllCategoryUseCase, DeleteCategoryUseCase deleteCategoryUseCase, UpdateCategoryUseCase updateCategoryUseCase, ListCategoryByNameUseCase listCategoryByNameUseCase) {
        this.createCategoryUseCase = createCategoryUseCase;
        this.findByIdCategoryUseCase = findByIdCategoryUseCase;
        this.listAllCategoryUseCase = listAllCategoryUseCase;
        this.deleteCategoryUseCase = deleteCategoryUseCase;
        this.updateCategoryUseCase = updateCategoryUseCase;
        this.listCategoryByNameUseCase = listCategoryByNameUseCase;
    }

    @PostMapping("/create")
    public ResponseEntity<@NonNull Map<String, Object>> createCategory(@Valid @RequestBody CategoryRequest request) {
        Category newCategory = createCategoryUseCase.execute(CategoryMapper.toCategoryEntity(request));

        Map<String, Object> response = Map.of(
                "message", "Categoria criada com sucesso.",
                "category", CategoryMapper.toCategoryRequest(newCategory)
        );

        return ResponseEntity.ok(response);
    }

    @GetMapping("/all")
    public ResponseEntity<@NonNull  Map<String, Object>> listAllCategories() {
        List<Category> categories = listAllCategoryUseCase.execute();

        Map<String, Object> response = Map.of(
                "message", "Categorias encontradas com sucesso.",
                "vehicle", CategoryMapper.toCategoryRequestList(categories));

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<@NonNull Map<String, Object>> findCategoryById(@PathVariable("id") UUID id) {
        Category findCategory = findByIdCategoryUseCase.execute(id);

        Map<String, Object> response = Map.of(
                "message", "Categoria encontrada com sucesso.",
                "category", CategoryMapper.toCategoryRequest(findCategory)
        );

        return ResponseEntity.ok(response);
    }

    @GetMapping("/find/")
    public ResponseEntity<@NonNull Map<String, Object>> findCategoryByName(@RequestParam("name") String name) {
        List<Category> findCategory = listCategoryByNameUseCase.execute(name);

        Map<String, Object> response = Map.of(
                "message", "Categoria(s) encontrada com sucesso.",
                "category", CategoryMapper.toCategoryRequestList(findCategory)
        );

        return ResponseEntity.ok(response);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<@NonNull Map<String, Object>> updateCategory(@Valid  @RequestBody CategoryRequest request, @PathVariable("id") UUID id) {
        Category updatedCategory = updateCategoryUseCase.execute(CategoryMapper.toCategoryEntity(request), id);

        Map<String, Object> response = Map.of(
                "message", "Categoria atualizada com sucesso.",
                "category", CategoryMapper.toCategoryRequest(updatedCategory)
        );

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<@NonNull Void> delete(@PathVariable UUID id) {
        deleteCategoryUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
