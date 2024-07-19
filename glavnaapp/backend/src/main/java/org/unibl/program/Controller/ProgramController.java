package org.unibl.program.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.unibl.program.Entity.Program;
import org.unibl.program.Entity.Requests.ProgramRequest;
import org.unibl.program.Service.ProgramService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/program")
public class ProgramController {

    ProgramService programService;
    public ProgramController(ProgramService programService){this.programService = programService;}

    @PostMapping
    public ResponseEntity<Program> createProgram(@Valid @RequestBody ProgramRequest programRequest) {
        Program program = programService.createProgram(programRequest);
        return new ResponseEntity<>(program, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Program> getAll() {
        return programService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Program> getProgram(@PathVariable("id") Integer id) {
        Optional<Program> program = programService.getProgram(id);
        return program.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        programService.delete(id);
    }
}
