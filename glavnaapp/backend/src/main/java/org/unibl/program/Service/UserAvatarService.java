package org.unibl.program.Service;

import org.springframework.stereotype.Service;
import org.unibl.program.Entity.Requests.UserAvatarRequest;
import org.unibl.program.Entity.UserAvatar;

import java.util.List;
import java.util.Optional;

@Service
public interface UserAvatarService {
    List<UserAvatar> getAll();
    UserAvatar createUserAvatar(UserAvatarRequest userAvatarRequest);
    Optional<UserAvatar> getUserAvatar(Integer id);
    void delete(Integer id);
}
