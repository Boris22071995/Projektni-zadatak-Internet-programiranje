package org.unibl.program.Service.Implementation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unibl.program.Entity.Requests.UserAvatarRequest;
import org.unibl.program.Entity.User;
import org.unibl.program.Entity.UserAvatar;
import org.unibl.program.Repository.UserAvatarRepository;
import org.unibl.program.Service.UserAvatarService;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserAvatarServiceImpl implements UserAvatarService {
   @Autowired
   private final UserAvatarRepository userAvatarRepository;

   public UserAvatarServiceImpl(UserAvatarRepository userAvatarRepository) {
       this.userAvatarRepository = userAvatarRepository;
   }

    @Override
    public List<UserAvatar> getAll() {
        return userAvatarRepository.findAll();
    }

    @Override
    public UserAvatar createUserAvatar(UserAvatarRequest userAvatarRequest) {
       UserAvatar userAvatar = UserAvatar.builder().idUserAvatar(userAvatarRequest.getIdUserAvatar())
                                                    .content(userAvatarRequest.getContent())
                                                    .useridUser(userAvatarRequest.getUseridUser()).build();
       UserAvatar saved = userAvatarRepository.save(userAvatar);
       return saved;
    }

    @Override
    public Optional<UserAvatar> getUserAvatar(Integer id) {
       log.info("Getting userAvatar with id: " + id);
       return userAvatarRepository.findById(id);
    }

    @Override
    public void delete(Integer id) {
        userAvatarRepository.deleteById(id);
    }
}
