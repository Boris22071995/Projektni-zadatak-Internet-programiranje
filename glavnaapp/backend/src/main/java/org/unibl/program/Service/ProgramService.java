package org.unibl.program.Service;

import org.springframework.stereotype.Service;
import org.unibl.program.Entity.Program;
import org.unibl.program.Entity.Requests.ProgramRequest;

import java.util.List;
import java.util.Optional;

@Service
public interface ProgramService {
    List<Program> getAll();
    Program createProgram(ProgramRequest programRequest);
    Optional<Program> getProgram(Integer id);
    void delete(Integer id);
}
