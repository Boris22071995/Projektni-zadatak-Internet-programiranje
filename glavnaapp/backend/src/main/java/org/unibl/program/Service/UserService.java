package org.unibl.program.Service;

import org.mapstruct.control.MappingControl;
import org.springframework.stereotype.Service;
import org.unibl.program.Entity.Requests.UserRequest;
import org.unibl.program.Entity.User;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    List<User> getAll();
    User createUser(UserRequest userRequest);
    Optional<User> getUser(Integer id);
    void delete(Integer id);
    Optional<User> getUsersByUsername(String username);
    User updatePincode(User user);
    User updateActive(User user, Byte active);
}
