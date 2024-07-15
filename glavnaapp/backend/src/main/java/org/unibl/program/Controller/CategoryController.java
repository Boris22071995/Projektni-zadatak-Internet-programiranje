package org.unibl.program.Controller;

import io.swagger.models.auth.In;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.unibl.program.Entity.Category;
import org.unibl.program.Entity.Requests.CategoryRequest;
import org.unibl.program.Service.CategoryService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController

@RequestMapping("/category")
public class CategoryController {

    CategoryService categoryService;
    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }
    @GetMapping
    public List<Category> getAll(){
        return categoryService.getAll();
    }

    @PostMapping
    public ResponseEntity<Category> createCategorys(@Valid @RequestBody CategoryRequest categoryRequest) {
        Category category = categoryService.createCategory(categoryRequest);
        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable("id") Integer id) {
        Optional<Category> category = categoryService.getCategory(id);
        return category.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
