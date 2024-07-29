package org.unibl.program.Service;

import org.springframework.stereotype.Service;
import org.unibl.program.Entity.Question;
import org.unibl.program.Entity.Requests.QuestionRequest;

import java.util.List;
import java.util.Optional;

@Service
public interface QuestionService {
    List<Question> getAll();
    Question createQuestion(QuestionRequest questionRequest);
    Optional<Question> getQuestion(Integer id);
    void delete(Integer id);
}
