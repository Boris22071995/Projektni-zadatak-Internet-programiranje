package org.unibl.program.Service.Implementation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unibl.program.Entity.Category;
import org.unibl.program.Entity.Requests.CategoryRequest;
import org.unibl.program.Repository.CategoryRepository;
import org.unibl.program.Service.CategoryService;
import org.unibl.program.exception.CategoryNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private final CategoryRepository categoryRepository;
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category createCategory(CategoryRequest categoryRequest) {
        Category category = Category.builder().idCategory(categoryRequest.getIdCategory()).name(categoryRequest.getName()).build();
        Category saved = categoryRepository.save(category);
        return saved;
    }

    @Override
    public Optional<Category> getCategory(Integer id) throws CategoryNotFoundException {
        log.info("Getting category with id: " + id);
        return categoryRepository.findById(id);
    }

}
