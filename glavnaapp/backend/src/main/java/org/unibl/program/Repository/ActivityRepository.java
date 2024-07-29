package org.unibl.program.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.unibl.program.Entity.Activity;

import java.util.List;
import java.util.Optional;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Integer> {
    List<Activity> findAll();
    Activity save(Activity activity);
    Optional<Activity> findById(Integer id);
    void deleteById(Integer id);
}
