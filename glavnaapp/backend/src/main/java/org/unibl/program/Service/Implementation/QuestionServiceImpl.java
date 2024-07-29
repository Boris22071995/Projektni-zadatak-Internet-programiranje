package org.unibl.program.Service.Implementation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unibl.program.Entity.Question;
import org.unibl.program.Entity.Requests.QuestionRequest;
import org.unibl.program.Repository.QuestionRepository;
import org.unibl.program.Service.QuestionService;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private final QuestionRepository questionRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public List<Question> getAll() {
        return questionRepository.findAll();
    }

    @Override
    public Question createQuestion(QuestionRequest questionRequest) {
        Question question = Question.builder().idQuestion(questionRequest.getIdQuestion())
                                              .userIdUser(questionRequest.getUserIdUser())
                                              .programIdProgram(questionRequest.getProgramIdProgram())
                                              .text(questionRequest.getText()).build();
        Question saved = questionRepository.save(question);
        return saved;
    }

    @Override
    public Optional<Question> getQuestion(Integer id) {
        log.info("Getting question with id: " + id);
        return questionRepository.findById(id);
    }

    @Override
    public void delete(Integer id) {
        questionRepository.deleteById(id);
    }

}
