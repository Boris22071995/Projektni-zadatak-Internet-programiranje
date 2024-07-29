package org.unibl.program.Repository;

import io.swagger.models.auth.In;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.unibl.program.Entity.UserHasProgram;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserHasProgramRepository extends JpaRepository<UserHasProgram, Integer> {
    List<UserHasProgram> findAll();
    UserHasProgram save(UserHasProgram userHasProgram);
    Optional<UserHasProgram> findById(Integer id);
    void deleteById(Integer id);
}
