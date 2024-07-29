package org.unibl.program.Controller;

import io.swagger.models.auth.In;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.unibl.program.Entity.Diary;
import org.unibl.program.Entity.Requests.DiaryRequest;
import org.unibl.program.Service.DiaryService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/diary")
public class DiaryController {
    DiaryService diaryService;

    public DiaryController(DiaryService diaryService) {
        this.diaryService = diaryService;
    }

    @GetMapping
    public List<Diary> getAll() {
        return diaryService.getAll();
    }

    @PostMapping
    public ResponseEntity<Diary> createDiary(@Valid @RequestBody DiaryRequest diaryRequest) {
        Diary diary = diaryService.createDiary(diaryRequest);
        return new ResponseEntity<>(diary, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Diary> getDiary(@PathVariable("id") Integer id) {
        Optional<Diary> diary = diaryService.getDiary(id);
        return diary.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        diaryService.delete(id);
    }
}
