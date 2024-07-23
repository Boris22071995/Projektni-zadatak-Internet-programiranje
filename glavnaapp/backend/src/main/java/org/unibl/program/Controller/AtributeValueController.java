package org.unibl.program.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.unibl.program.Entity.AtributeValue;
import org.unibl.program.Entity.Requests.AtributeValueRequest;
import org.unibl.program.Service.AtributeValueService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/atributeValue")
public class AtributeValueController {
    AtributeValueService atributeValueService;
    public AtributeValueController(AtributeValueService atributeValueService){this.atributeValueService = atributeValueService;}

    @GetMapping
    public List<AtributeValue> getAll(){return atributeValueService.getAll();}

    @PostMapping
    public ResponseEntity<AtributeValue> createAtributeValue(@Valid @RequestBody AtributeValueRequest atributeValueRequest) {
        AtributeValue atributeValue = atributeValueService.createAtributeValue(atributeValueRequest);
        return new ResponseEntity<>(atributeValue,HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AtributeValue> getAtributeValue(@PathVariable("id") Integer id) {
        Optional<AtributeValue> atributeValue = atributeValueService.getAtributeValue(id);
        return atributeValue.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        atributeValueService.delete(id);
    }
}
