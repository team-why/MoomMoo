package com.hwhy.moommoo.domain.account.dto;

import com.hwhy.moommoo.global.code.Gender;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AccountCreateReqDto {

    private String name;
    private String email;
    private String password;
    private Gender gender;
    private LocalDate birthdayDate;
    private String auth;

}
