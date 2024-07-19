package org.unibl.program.Repository;

import com.sun.source.tree.OpensTree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.unibl.program.Entity.Instructor;

import java.util.List;
import java.util.Optional;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Integer> {
    List<Instructor> findAll();
    Instructor save(Instructor instructor);
    Optional<Instructor> findById(Integer id);
    void deleteById(Integer integer);
}
