package com.hwhy.moommoo.domain.user.service;


import com.hwhy.moommoo.domain.user.domain.User;
import com.hwhy.moommoo.domain.user.domain.UserDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface UserService {
    List<User> findAll();
    Optional<User> findById(long id);
    void save(User user);
    boolean existsById(long id);
    long count();
    void deleteById(long id);
    String signup(User user);
    UserDto signin(User user);

}
