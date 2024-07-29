package org.unibl.program.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.unibl.program.Entity.UserAvatar;

import java.util.List;
import java.util.Optional;

public interface UserAvatarRepository extends JpaRepository<UserAvatar, Integer> {
    List<UserAvatar> findAll();
    UserAvatar save(UserAvatar userAvatar);
    Optional<UserAvatar> findById(Integer id);
    void deleteById(Integer id);
}
