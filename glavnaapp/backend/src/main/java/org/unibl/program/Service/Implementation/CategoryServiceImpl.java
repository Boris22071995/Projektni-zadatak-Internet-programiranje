package org.unibl.program.Service.Implementation;

import org.springframework.stereotype.Service;
import org.unibl.program.Entity.Category;
import org.unibl.program.Entity.Contact;
import org.unibl.program.Entity.Requests.CategoryRequest;
import org.unibl.program.Repository.CategoryRepository;
import org.unibl.program.Repository.ContactRepostory;
import org.unibl.program.Service.CategoryService;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category createCategory() {
        Category category = new Category();
        //category.setName("boris");
        return categoryRepository.save(category);
    }
}
