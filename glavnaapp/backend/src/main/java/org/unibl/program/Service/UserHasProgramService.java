package org.unibl.program.Service;

import jdk.dynalink.linker.LinkerServices;
import org.springframework.stereotype.Service;
import org.unibl.program.Entity.Requests.UserHasProgramRequest;
import org.unibl.program.Entity.UserHasProgram;

import java.util.List;
import java.util.Optional;

@Service
public interface UserHasProgramService {
    List<UserHasProgram> getAll();
    UserHasProgram createUserHasProgram(UserHasProgramRequest userHasProgramRequest);
    Optional<UserHasProgram> getUserHasProgram(Integer id);
    void delete(Integer id);
}
