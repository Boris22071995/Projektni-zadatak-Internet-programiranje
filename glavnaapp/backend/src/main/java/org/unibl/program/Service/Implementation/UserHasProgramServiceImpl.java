package org.unibl.program.Service.Implementation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unibl.program.Entity.Requests.UserHasProgramRequest;
import org.unibl.program.Entity.UserHasProgram;
import org.unibl.program.Repository.UserHasProgramRepository;
import org.unibl.program.Service.UserHasProgramService;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserHasProgramServiceImpl implements UserHasProgramService {
    @Autowired
    private final UserHasProgramRepository userHasProgramRepository;

    public UserHasProgramServiceImpl(UserHasProgramRepository userHasProgramRepository) {
        this.userHasProgramRepository = userHasProgramRepository;
    }
    @Override
    public List<UserHasProgram> getAll() {
        return userHasProgramRepository.findAll();
    }

    @Override
    public UserHasProgram createUserHasProgram(UserHasProgramRequest userHasProgramRequest) {
        UserHasProgram userHasProgram = UserHasProgram.builder().idUserHasProgram(userHasProgramRequest.getIdUserHasProgram())
                                                                .userIdUser(userHasProgramRequest.getUserIdUser())
                                                                .programIdProgram(userHasProgramRequest.getProgramIdProgram())
                                                                .date(userHasProgramRequest.getDate())
                                                                .paymentMethod(userHasProgramRequest.getPaymentMethod())
                                                                .pay(userHasProgramRequest.getPay()).build();
        UserHasProgram saved = userHasProgramRepository.save(userHasProgram);
        return saved;
    }

    @Override
    public Optional<UserHasProgram> getUserHasProgram(Integer id) {
       log.info("Getting userHasProgram with id: " + id);
        return userHasProgramRepository.findById(id);
    }

    @Override
    public void delete(Integer id) {
        userHasProgramRepository.deleteById(id);
    }
}
