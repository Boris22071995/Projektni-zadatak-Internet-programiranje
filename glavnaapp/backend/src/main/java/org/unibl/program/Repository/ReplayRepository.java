package org.unibl.program.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.unibl.program.Entity.Replay;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReplayRepository extends JpaRepository<Replay,Integer> {
    List<Replay> findAll();
    Replay save(Replay replay);
    Optional<Replay> findById(Integer id);
    void deleteById(Integer id);
}
