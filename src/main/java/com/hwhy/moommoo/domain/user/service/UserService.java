package com.hwhy.moommoo.domain.user.service;


import com.hwhy.moommoo.domain.user.dto.request.UserSignInRequestDto;
import com.hwhy.moommoo.domain.user.dto.request.UserSignUpRequestDto;
import com.hwhy.moommoo.domain.user.dto.response.UserSignInResponseDto;
import com.hwhy.moommoo.domain.user.entity.User;
import com.hwhy.moommoo.domain.user.dto.request.UserDto;
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
    String signup(UserSignUpRequestDto userSignUpRequestDto);
    UserSignInResponseDto signin(UserSignInRequestDto userSignInRequestDto);

}
