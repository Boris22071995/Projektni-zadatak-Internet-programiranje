package org.unibl.program.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.unibl.program.Entity.Question;
import org.unibl.program.Entity.Requests.QuestionRequest;
import org.unibl.program.Entity.Requests.UserRequest;
import org.unibl.program.Entity.User;
import org.unibl.program.Service.QuestionService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/question")
public class QuestionController {
    QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping
    public List<Question> getAll() {
        return questionService.getAll();
    }

    @PostMapping
    public ResponseEntity<Question> createQuestion(@Valid @RequestBody QuestionRequest questionRequest) {
        Question question = questionService.createQuestion(questionRequest);
        return new ResponseEntity<>(question, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Question> getQuestion(@PathVariable("id") Integer id) {
        Optional<Question> question = questionService.getQuestion(id);
        return question.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        questionService.delete(id);
    }

}
