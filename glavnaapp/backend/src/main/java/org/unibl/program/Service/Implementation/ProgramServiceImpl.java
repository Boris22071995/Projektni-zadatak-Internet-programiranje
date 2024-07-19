package org.unibl.program.Service.Implementation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unibl.program.Entity.Program;
import org.unibl.program.Entity.Requests.ProgramRequest;
import org.unibl.program.Repository.ProgramRepository;
import org.unibl.program.Service.ProgramService;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProgramServiceImpl implements ProgramService {
    @Autowired
    private final ProgramRepository programRepository;
    public ProgramServiceImpl(ProgramRepository programRepository) {this.programRepository = programRepository;}

    @Override
    public List<Program> getAll() {
        return programRepository.findAll();
    }

    @Override
    public Program createProgram(ProgramRequest programRequest) {
        Program program = Program.builder().idProgram(programRequest.getIdProgram())
                                            .name(programRequest.getName())
                                            .description(programRequest.getDescription())
                                            .price(programRequest.getPrice())
                                            .intensityLevel(programRequest.getIntensityLevel())
                                            .duration(programRequest.getDuration())
                                            .contactPerson(programRequest.getContactPerson())
                                            .picture(programRequest.getPicture())
                                            .locationName(programRequest.getLocationName())
                                            .locationAdress(programRequest.getLocationAdress())
                                            .instructorIdinstructor(programRequest.getInstructorIdinstructor())
                                            .categoryIdCategory(programRequest.getCategoryIdCategory()).build();
        Program saved = programRepository.save(program);
        return saved;
    }

    @Override
    public Optional<Program> getProgram(Integer id) {
        log.info("Getting program with id: " + id);
        return programRepository.findById(id);
    }

    @Override
    public void delete(Integer id) {
    programRepository.deleteById(id);
    }
}
