package org.unibl.program.Controller;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.unibl.program.Entity.Category;
import org.unibl.program.Entity.Contact;
import org.unibl.program.Entity.Requests.CategoryRequest;
import org.unibl.program.Entity.Requests.ContactRequest;
import org.unibl.program.Service.CategoryService;

import java.util.List;

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
    @PostMapping("/{username}")
    public ResponseEntity<Category> createCategory(@PathVariable("username")String username) {
        System.out.println(username);
        Category category = categoryService.createCategory();
        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }
}
