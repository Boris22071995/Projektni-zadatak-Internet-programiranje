package org.unibl.program.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.unibl.program.Entity.Requests.UserAvatarRequest;
import org.unibl.program.Entity.UserAvatar;
import org.unibl.program.Service.UserAvatarService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/userAvatar")
public class UserAvatarController {

    UserAvatarService userAvatarService;
    public UserAvatarController(UserAvatarService userAvatarService) {
        this.userAvatarService = userAvatarService;
    }

    @GetMapping
    public List<UserAvatar> getAll() {
        return userAvatarService.getAll();
    }

    @PostMapping
    public ResponseEntity<UserAvatar> createUserAvatar(@Valid @RequestBody UserAvatarRequest userAvatarRequest) {
        UserAvatar userAvatar = userAvatarService.createUserAvatar(userAvatarRequest);
        return new ResponseEntity<>(userAvatar, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserAvatar> getUserAvatar(@PathVariable("id") Integer id) {
        Optional<UserAvatar> userAvatar = userAvatarService.getUserAvatar(id);
        return userAvatar.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        userAvatarService.delete(id);
    }

}
