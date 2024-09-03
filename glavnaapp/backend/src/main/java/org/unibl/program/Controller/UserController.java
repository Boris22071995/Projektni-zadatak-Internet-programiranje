package org.unibl.program.Controller;


import org.apache.logging.log4j.LogManager;
import org.mapstruct.control.MappingControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.unibl.program.Entity.Requests.PincodeRequest;
import org.unibl.program.Entity.Requests.UserRequest;
import org.unibl.program.Entity.User;
import org.unibl.program.Service.EmailService;
import org.unibl.program.Service.UserService;
import org.apache.logging.log4j.Logger;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;


@RestController
@RequestMapping("/user")
public class UserController {
    UserService userService;
    private final EmailService emailService;
    private static final Logger logger = LogManager.getLogger(UserController.class);
    public UserController(UserService userService, EmailService emailService){this.userService = userService; this.emailService = emailService;}

    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody UserRequest userRequest) {
        User user = userService.createUser(userRequest);

        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
    @PostMapping("/generate-pincode/{id}")
    public ResponseEntity<User> generatePincode(@PathVariable("id") Integer id){
        Optional<User> user = userService.getUser(id);

        if(user.isPresent()) {
            User userTmp = user.get();
            Integer pinCodeGen = new Random().nextInt(9000) + 1000;
            userTmp.setPinCode(pinCodeGen);
            logger.info("POST generated new pin code");
            userTmp = userService.updatePincode(userTmp);
            logger.info("Email with pincode sent.");
            return ResponseEntity.ok(userTmp);
        }
        logger.error("POST no content user");
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/activate-user/{id}")
    public ResponseEntity<User> activateUser(@PathVariable("id") Integer id, @RequestBody PincodeRequest pincodeRequest) {
        Optional<User> optionalUser = userService.getUser(id);

        if(optionalUser.isPresent()){
            User user = optionalUser.get();

            if(Objects.equals(user.getPinCode(), pincodeRequest.getPinCode())){
                logger.info("POST activate successfully account");
                user = userService.updateActive(user,(byte)1);
                return ResponseEntity.ok(user);
            }else {
                logger.error("POST not activated successfully account");
                return ResponseEntity.status(403).build();
            }
        }
        logger.error("POST users not found");
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/userName")
    public User getUserbyNameId() {
        List<User> users = userService.getAll();
        User user = users.get(users.size() - 1);
        return user;
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") Integer id) {
        Optional<User> user = userService.getUser(id);
        return user.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        userService.delete(id);
    }

}

