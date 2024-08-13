package org.unibl.program.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.unibl.program.Entity.Replay;
import org.unibl.program.Entity.Requests.ReplayRequest;
import org.unibl.program.Entity.Requests.UserRequest;
import org.unibl.program.Entity.User;
import org.unibl.program.Service.ReplayService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/replay")
public class ReplayController {
    ReplayService replayService;
    public ReplayController(ReplayService replayService) {
        this.replayService = replayService;
    }

    @GetMapping
    public List<Replay> getAll() {
        return replayService.getAll();
    }

    @PostMapping
    public ResponseEntity<Replay> createReplay(@Valid @RequestBody ReplayRequest replayRequest) {
        Replay replay = replayService.createReplay(replayRequest);
        return new ResponseEntity<>(replay, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Replay> getReplay(@PathVariable("id") Integer id) {
        Optional<Replay> replay = replayService.getReplay(id);
        return replay.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        replayService.delete(id);
    }

}
