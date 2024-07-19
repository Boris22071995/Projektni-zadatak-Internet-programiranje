package org.unibl.program.Service;

import org.springframework.stereotype.Service;
import org.unibl.program.Entity.Instructor;
import org.unibl.program.Entity.Requests.InstructorRequest;
import org.unibl.program.exception.InstructorNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public interface InstructorService {
    List<Instructor> getAll();
    Instructor createInstructor(InstructorRequest instructorRequest);
    Optional<Instructor> getInstructor(Integer id)throws InstructorNotFoundException;
    void delete(Integer id);
}
