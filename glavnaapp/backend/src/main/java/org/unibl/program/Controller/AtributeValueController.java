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
        return new ResponseEntity<>(atributeValue, HttpStatus.CREATED);
    }

    @GetMapping("/{id}/{id2}/{id3}")
    public ResponseEntity<AtributeValue> getAtributeValue(@PathVariable("id") Integer id, @PathVariable("id2") Integer id2, @PathVariable("id3") Integer id3) {
        Optional<AtributeValue> atributeValue = atributeValueService.getAtributeValue(id,id2,id3);
        return atributeValue.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}/{id2}/{id3}")
    public void delete(@PathVariable("id") Integer id, @PathVariable("id2") Integer id2, @PathVariable("id3") Integer id3) {
        atributeValueService.delete(id,id2,id3);
    }
}
