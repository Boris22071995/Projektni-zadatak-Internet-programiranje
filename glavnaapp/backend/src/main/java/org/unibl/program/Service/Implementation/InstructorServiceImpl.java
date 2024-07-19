package org.unibl.program.Service.Implementation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unibl.program.Entity.Instructor;
import org.unibl.program.Entity.Requests.InstructorRequest;
import org.unibl.program.Repository.InstructorRepository;
import org.unibl.program.Service.InstructorService;
import org.unibl.program.exception.InstructorNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class InstructorServiceImpl implements InstructorService {
    @Autowired
    private final InstructorRepository instructorRepository;

    public InstructorServiceImpl(InstructorRepository instructorRepository){this.instructorRepository = instructorRepository;}

    @Override
    public List<Instructor> getAll() {
        return instructorRepository.findAll();
    }

    @Override
    public Instructor createInstructor(InstructorRequest instructorRequest) {
        Instructor instructor = Instructor.builder().idinstructor(instructorRequest.getIdinstructor()).firstName(instructorRequest.getFirstName()).lastName(instructorRequest.getLastName()).age(instructorRequest.getAge()).expirience(instructorRequest.getExpirience()).build();
        Instructor saved = instructorRepository.save(instructor);
        return saved;
    }

    @Override
    public Optional<Instructor> getInstructor(Integer id) throws InstructorNotFoundException {
        log.info("Getting instructor with id: " + id);
        return instructorRepository.findById(id);
    }

    @Override
    public void delete(Integer id) {
        instructorRepository.deleteById(id);
    }
}
