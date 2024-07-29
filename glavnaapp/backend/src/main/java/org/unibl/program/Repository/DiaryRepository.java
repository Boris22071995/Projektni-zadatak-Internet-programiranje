package org.unibl.program.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.unibl.program.Entity.Diary;

import java.util.List;
import java.util.Optional;

@Repository
public interface DiaryRepository extends JpaRepository<Diary, Integer> {
    List<Diary> findAll();
    Diary save(Diary diary);
    Optional<Diary> findById(Integer id);
    void deleteById(Integer id);
}
