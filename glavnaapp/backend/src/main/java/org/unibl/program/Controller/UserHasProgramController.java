package org.unibl.program.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.unibl.program.Entity.Requests.UserHasProgramRequest;
import org.unibl.program.Entity.Requests.UserRequest;
import org.unibl.program.Entity.User;
import org.unibl.program.Entity.UserHasProgram;
import org.unibl.program.Service.UserHasProgramService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/userHasProgram")
public class UserHasProgramController {
    UserHasProgramService userHasProgramService;

    public UserHasProgramController(UserHasProgramService userHasProgramService) {
        this.userHasProgramService = userHasProgramService;
    }

    @GetMapping
    public List<UserHasProgram> getAll() {
        return userHasProgramService.getAll();
    }

    @PostMapping
    public ResponseEntity<UserHasProgram> createUser(@Valid @RequestBody UserHasProgramRequest userHasProgramRequest) {
        UserHasProgram userHasProgram = userHasProgramService.createUserHasProgram(userHasProgramRequest);
        return new ResponseEntity<>(userHasProgram, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserHasProgram> getUserHasProgram(@PathVariable("id") Integer id) {
        Optional<UserHasProgram> userHasProgram = userHasProgramService.getUserHasProgram(id);
        return userHasProgram.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        userHasProgramService.delete(id);
    }

}
