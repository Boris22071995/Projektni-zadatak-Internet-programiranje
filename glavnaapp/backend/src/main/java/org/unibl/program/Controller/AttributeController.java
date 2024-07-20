package org.unibl.program.Controller;

import jdk.dynalink.linker.LinkerServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.unibl.program.Entity.Attribute;
import org.unibl.program.Entity.Requests.AttributeRequest;
import org.unibl.program.Service.AttributeService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/attribute")
public class AttributeController {

    AttributeService attributeService;
    public AttributeController(AttributeService attributeService) {this.attributeService = attributeService;}

    @GetMapping
    public List<Attribute> getAll(){return attributeService.getAll();}

    @PostMapping
    public ResponseEntity<Attribute> createAttribute(@Valid @RequestBody AttributeRequest attributeRequest) {
        Attribute attribute = attributeService.createAttribute(attributeRequest);
        return new ResponseEntity<>(attribute, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Attribute> getAttribute(@PathVariable("id") Integer id) {
        Optional<Attribute> attribute = attributeService.getAttribute(id);
        return attribute.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){
        attributeService.delete(id);
    }
}
