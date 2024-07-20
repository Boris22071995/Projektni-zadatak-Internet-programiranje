package org.unibl.program.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.unibl.program.Entity.Attribute;

import java.util.List;
import java.util.Optional;

@Repository
public interface AttributeRepository extends JpaRepository<Attribute, Integer> {
    List<Attribute> findAll();
    Attribute save(Attribute attribute);
    Optional<Attribute> findById(Integer id);
    void deleteById(Integer integer);
}
