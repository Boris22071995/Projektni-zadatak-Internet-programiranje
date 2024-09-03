package org.unibl.program.Service.Implementation;

import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mapstruct.control.MappingControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unibl.program.Controller.UserController;
import org.unibl.program.Entity.Requests.UserRequest;
import org.unibl.program.Entity.User;
import org.unibl.program.Repository.UserRepository;
import org.unibl.program.Service.EmailService;
import org.unibl.program.Service.UserService;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private final UserRepository userRepository;
    private final EmailService emailService;
    private static final Logger logger = LogManager.getLogger(UserController.class);
    private static final String GENERIC_MESSAGE = "Hvala što ste se prijavili na CleanBL! Kliknite na sljedeći link kako bi aktivirali nalog: ";
    private static final String SUBJECT_MESSAGE = "Please activate your account";

    public UserServiceImpl(UserRepository userRepository, EmailService emailService) {this.userRepository = userRepository; this.emailService = emailService;}

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(UserRequest userRequest) {
        User user = User.builder().idUser(userRequest.getIdUser())
                                  .userName(userRequest.getUserName())
                                  .password(userRequest.getPassword())
                                  .firstName(userRequest.getFirstName())
                                  .lastName(userRequest.getLastName())
                                  .email(userRequest.getEmail())
                                  .city(userRequest.getCity())
                                  .isActivated(userRequest.getIsActivated())
                                  .programIdProgram(userRequest.getProgramIdProgram()).build();
        user.setActivated((byte)0);
        Integer pinCodeGen = new Random().nextInt(9000) + 1000;
        user.setPinCode(pinCodeGen);
        emailService.sendMessage(user.getEmail(), "Online fitness IP - ACTIVATE PINCODE", "Vas aktivacioni pin code: "+pinCodeGen);
        logger.info("POST successfully created user");
        User saved = userRepository.save(user);
        return saved;
    }

    @Override
    public Optional<User> getUser(Integer id) {
        log.info("Getting user with id: " + id);
        return userRepository.findById(id);
    }

    @Override
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<User> getUsersByUsername(String username) {
        return userRepository.getUserByUserName(username);
    }

    @Override
    public User updatePincode(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateActive(User user, Byte active) {
        user.setActivated(active);
        return userRepository.save(user);
    }
}
