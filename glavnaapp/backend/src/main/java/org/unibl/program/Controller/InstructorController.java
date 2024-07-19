package org.unibl.program.Controller;

import io.swagger.models.auth.In;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.unibl.program.Entity.Instructor;
import org.unibl.program.Entity.Requests.InstructorRequest;
import org.unibl.program.Service.InstructorService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/instructor")
public class InstructorController {

    InstructorService instructorService;
    public InstructorController(InstructorService instructorService){this.instructorService = instructorService;}

    @PostMapping
    public ResponseEntity<Instructor> createInstructor(@Valid @RequestBody InstructorRequest instructorRequest) {
        Instructor instructor = instructorService.createInstructor(instructorRequest);
        return new ResponseEntity<>(instructor, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Instructor> getAll() {return instructorService.getAll();}

    @GetMapping("/{id}")
    public ResponseEntity<Instructor> getInstructor(@PathVariable("id") Integer id) {
        Optional<Instructor> instructor = instructorService.getInstructor(id);
        return instructor.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        instructorService.delete(id);
    }
}
