package org.unibl.program.Service.Implementation;

import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unibl.program.Entity.AtributeValue;
import org.unibl.program.Entity.Requests.AtributeValueRequest;
import org.unibl.program.Repository.AtributeValueRepository;
import org.unibl.program.Service.AtributeValueService;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class AtributeValueServiceImpl implements AtributeValueService {
    @Autowired
    private final AtributeValueRepository atributeValueRepository;
    public AtributeValueServiceImpl(AtributeValueRepository atributeValueRepository) {this.atributeValueRepository = atributeValueRepository;}


    @Override
    public List<AtributeValue> getAll() {
        return atributeValueRepository.findAll();
    }

    @Override
    public AtributeValue createAtributeValue(AtributeValueRequest atributeValueRequest) {
        AtributeValue atributeValue = AtributeValue.builder().idatributeValue(atributeValueRequest.getIdatributeValue())
                                                             .value(atributeValueRequest.getValue())
                                                             .programIdProgram(atributeValueRequest.getProgramIdProgram())
                                                             .atributeIdAttribute(atributeValueRequest.getAtributeIdAttribute()).build();
        AtributeValue saved = atributeValueRepository.save(atributeValue);
        return saved;
    }

    @Override
    public Optional<AtributeValue> getAtributeValue(Integer id) {
        log.info("Getting attriuteValue with id: " + id);
        return atributeValueRepository.findById(id);
    }

    @Override
    public void delete(Integer id) {
        atributeValueRepository.deleteById(id);

    }
}
