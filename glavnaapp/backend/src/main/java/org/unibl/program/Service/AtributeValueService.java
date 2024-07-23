package org.unibl.program.Service;

import io.swagger.models.auth.In;
import org.springframework.stereotype.Service;
import org.unibl.program.Entity.AtributeValue;
import org.unibl.program.Entity.Requests.AtributeValueRequest;

import java.util.List;
import java.util.Optional;

@Service
public interface AtributeValueService {
    List<AtributeValue> getAll();
    AtributeValue createAtributeValue(AtributeValueRequest atributeValueRequest);
    Optional<AtributeValue> getAtributeValue(Integer id);
    void delete(Integer id);
}
