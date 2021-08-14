package com.hwhy.moommoo.domain.Account.dto;

import com.hwhy.moommoo.domain.Account.entity.Account;
import com.hwhy.moommoo.global.code.Gender;
import lombok.Builder;
import lombok.Getter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;

@Getter
public class AccountReqDto {

    private String name;
    private String email;
    private String password;
    private Gender gender;
    private String phoneNumber;
    private LocalDate birth;

    public Account toEntity(PasswordEncoder passwordEncoder) {
        return Account.builder()
                .name(name)
                .email(email)
                .password(password)
                .gender(gender)
                .phoneNumber(phoneNumber)
                .birth(birth)
                .build();
    }

    public UsernamePasswordAuthenticationToken toAuthentication() {
        return new UsernamePasswordAuthenticationToken(email, password);
    }
}
