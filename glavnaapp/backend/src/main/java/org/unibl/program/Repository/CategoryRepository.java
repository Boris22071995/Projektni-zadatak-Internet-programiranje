package org.unibl.program.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.unibl.program.Entity.Category;

import java.util.List;
import java.util.Optional;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    List<Category> findAll();
    Category save(Category category);
    Optional<Category> findById(Integer id);

}
