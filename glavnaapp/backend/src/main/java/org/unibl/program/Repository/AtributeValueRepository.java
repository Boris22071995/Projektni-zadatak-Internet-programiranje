package org.unibl.program.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.unibl.program.Entity.AtributeValue;


import java.util.List;
import java.util.Optional;

@Repository
public interface AtributeValueRepository extends  JpaRepository<AtributeValue, Integer> {
    List<AtributeValue> findAll();
    AtributeValue save(AtributeValue atributeValue);
    Optional<AtributeValue> findById(Integer id);
    void deleteById(Integer id);
}
