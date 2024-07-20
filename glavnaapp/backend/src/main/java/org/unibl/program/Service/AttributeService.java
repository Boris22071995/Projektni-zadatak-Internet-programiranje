package org.unibl.program.Service;

import org.springframework.stereotype.Service;
import org.unibl.program.Entity.Attribute;
import org.unibl.program.Entity.Requests.AttributeRequest;

import java.util.List;
import java.util.Optional;

@Service
public interface AttributeService {
    List<Attribute> getAll();
    Attribute createAttribute(AttributeRequest attributeRequest);
    Optional<Attribute> getAttribute(Integer id);
    void delete(Integer id);

}
