package org.unibl.program.Service.Implementation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unibl.program.Entity.Attribute;
import org.unibl.program.Entity.Requests.AttributeRequest;
import org.unibl.program.Repository.AttributeRepository;
import org.unibl.program.Service.AttributeService;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class AttributeServiceImpl implements AttributeService {
    @Autowired
    private final AttributeRepository attributeRepository;

    public AttributeServiceImpl(AttributeRepository attributeRepository) {this.attributeRepository = attributeRepository;}

    @Override
    public List<Attribute> getAll() {
        return attributeRepository.findAll();
    }

    @Override
    public Attribute createAttribute(AttributeRequest attributeRequest) {
        Attribute attribute = Attribute.builder().idAttribute(attributeRequest.getIdAttribute())
                                                 .name(attributeRequest.getName())
                                                 .categoryIdCategory(attributeRequest.getCategoryIdCategory()).build();
        Attribute saved = attributeRepository.save(attribute);
        return saved;
    }

    @Override
    public Optional<Attribute> getAttribute(Integer id) {
        log.info("Getting attriute with id: " + id);
        return attributeRepository.findById(id);
    }

    @Override
    public void delete(Integer id) {
        attributeRepository.deleteById(id);
    }
}
