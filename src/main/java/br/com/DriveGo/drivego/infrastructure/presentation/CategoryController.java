package br.com.DriveGo.drivego.infrastructure.presentation;

import br.com.DriveGo.drivego.core.entities.Category;
import br.com.DriveGo.drivego.core.usecases.CreateCategoryUseCase;
import br.com.DriveGo.drivego.infrastructure.dtos.requests.CategoryRequest;
import br.com.DriveGo.drivego.infrastructure.mappers.CategoryMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private final CreateCategoryUseCase createCategoryUseCase;

    public CategoryController(CreateCategoryUseCase createCategoryUseCase) {
        this.createCategoryUseCase = createCategoryUseCase;
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
}
