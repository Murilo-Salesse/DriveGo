package br.com.DriveGo.drivego.infrastructure.presentation;

import br.com.DriveGo.drivego.core.entities.Category;
import br.com.DriveGo.drivego.core.usecases.CreateCategoryUseCase;
import br.com.DriveGo.drivego.core.usecases.FindByIdCategoryUseCase;
import br.com.DriveGo.drivego.core.usecases.ListAllCategoryUseCase;
import br.com.DriveGo.drivego.infrastructure.dtos.requests.CategoryRequest;
import br.com.DriveGo.drivego.infrastructure.mappers.CategoryMapper;
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

    public CategoryController(CreateCategoryUseCase createCategoryUseCase, FindByIdCategoryUseCase findByIdCategoryUseCase, ListAllCategoryUseCase listAllCategoryUseCase) {
        this.createCategoryUseCase = createCategoryUseCase;
        this.findByIdCategoryUseCase = findByIdCategoryUseCase;
        this.listAllCategoryUseCase = listAllCategoryUseCase;
    }

    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> createCategory(@RequestBody CategoryRequest request) {
        Category newCategory = createCategoryUseCase.execute(CategoryMapper.toCategoryEntity(request));

        Map<String, Object> response = Map.of(
                "message", "Categoria criada com sucesso.",
                "category", CategoryMapper.toCategoryRequest(newCategory)
        );

        return ResponseEntity.ok(response);
    }

    @GetMapping("/all")
    public ResponseEntity<Map<String, Object>> listAllCategories() {
        List<Category> categories = listAllCategoryUseCase.execute();

        Map<String, Object> response = Map.of(
                "message", "Categorias encontradas com sucesso.",
                "vehicle", CategoryMapper.toCategoryRequestList(categories));

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> findCategoryById(@PathVariable("id") UUID id) {
        Category findCategory = findByIdCategoryUseCase.execute(id);

        Map<String, Object> response = Map.of(
                "message", "Categoria encontrada com sucesso.",
                "category", CategoryMapper.toCategoryRequest(findCategory)
        );

        return ResponseEntity.ok(response);
    }
}
