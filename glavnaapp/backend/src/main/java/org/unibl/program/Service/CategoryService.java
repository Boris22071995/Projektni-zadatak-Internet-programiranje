package org.unibl.program.Service;

import org.springframework.stereotype.Service;
import org.unibl.program.Entity.Category;
import org.unibl.program.Entity.Requests.CategoryRequest;
import org.unibl.program.exception.CategoryNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public interface CategoryService {
    List<Category> getAll();
    Category createCategory(CategoryRequest categoryRequest);
    Optional<Category> getCategory(Integer id) throws CategoryNotFoundException;
    void delete(Integer id);

}
