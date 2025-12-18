package br.com.DriveGo.drivego.infrastructure.presentation;

import br.com.DriveGo.drivego.core.entities.Category;
import br.com.DriveGo.drivego.core.usecases.categories.*;
import br.com.DriveGo.drivego.infrastructure.dtos.requests.CategoryRequest;
import br.com.DriveGo.drivego.infrastructure.mappers.CategoryMapper;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
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

    public CategoryController(CreateCategoryUseCase createCategoryUseCase,
                              FindByIdCategoryUseCase findByIdCategoryUseCase,
                              ListAllCategoryUseCase listAllCategoryUseCase,
                              DeleteCategoryUseCase deleteCategoryUseCase,
                              UpdateCategoryUseCase updateCategoryUseCase,
                              ListCategoryByNameUseCase listCategoryByNameUseCase) {
        this.createCategoryUseCase = createCategoryUseCase;
        this.findByIdCategoryUseCase = findByIdCategoryUseCase;
        this.listAllCategoryUseCase = listAllCategoryUseCase;
        this.deleteCategoryUseCase = deleteCategoryUseCase;
        this.updateCategoryUseCase = updateCategoryUseCase;
        this.listCategoryByNameUseCase = listCategoryByNameUseCase;
    }

    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> createCategory(
            @Valid @RequestBody CategoryRequest request) {

        Category newCategory = createCategoryUseCase.execute(
                CategoryMapper.toCategoryEntity(request));

        Map<String, Object> data = Map.of(
                "message", "Categoria criada com sucesso.",
                "category", CategoryMapper.toCategoryRequest(newCategory)
        );

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("data", data));
    }

    @GetMapping("/all")
    public ResponseEntity<Map<String, Object>> listAllCategories() {
        List<Category> categories = listAllCategoryUseCase.execute();

        Map<String, Object> data = Map.of(
                "message", "Categoria(s) encontrada(s) com sucesso.",
                "categories", CategoryMapper.toCategoryRequestList(categories)
        );

        return ResponseEntity.ok(Map.of("data", data));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> findCategoryById(
            @PathVariable("id") UUID id) {

        Category findCategory = findByIdCategoryUseCase.execute(id);

        Map<String, Object> data = Map.of(
                "message", "Categoria encontrada com sucesso.",
                "category", CategoryMapper.toCategoryRequest(findCategory)
        );

        return ResponseEntity.ok(Map.of("data", data));
    }

    @GetMapping("/find/")
    public ResponseEntity<Map<String, Object>> findCategoryByName(
            @RequestParam("name") String name) {

        List<Category> findCategory = listCategoryByNameUseCase.execute(name);

        Map<String, Object> data = Map.of(
                "message", "Categoria(s) encontrada(s) com sucesso.",
                "categories", CategoryMapper.toCategoryRequestList(findCategory)
        );

        return ResponseEntity.ok(Map.of("data", data));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateCategory(
            @Valid @RequestBody CategoryRequest request,
            @PathVariable("id") UUID id) {

        Category updatedCategory = updateCategoryUseCase.execute(
                CategoryMapper.toCategoryEntity(request), id);

        Map<String, Object> data = Map.of(
                "message", "Categoria atualizada com sucesso.",
                "category", CategoryMapper.toCategoryRequest(updatedCategory)
        );

        return ResponseEntity.ok(Map.of("data", data));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable UUID id) {
        deleteCategoryUseCase.execute(id);

        Map<String, Object> data = Map.of(
                "message", "Categoria deletada com sucesso."
        );

        return ResponseEntity.ok(Map.of("data", data));
    }
}