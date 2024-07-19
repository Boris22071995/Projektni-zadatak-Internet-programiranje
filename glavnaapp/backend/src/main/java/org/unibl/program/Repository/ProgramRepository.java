package org.unibl.program.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.unibl.program.Entity.Program;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProgramRepository extends JpaRepository<Program, Integer> {
    List<Program> findAll();
    Program save(Program program);
    Optional<Program> findById(Integer id);
    void deleteById(Integer id);
}
