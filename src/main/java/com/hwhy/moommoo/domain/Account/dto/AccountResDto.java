package com.hwhy.moommoo.domain.Account.dto;

import com.hwhy.moommoo.domain.Account.entity.Account;
import com.hwhy.moommoo.global.code.Gender;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class AccountResDto {

    private String name;
    private String email;
    private Gender gender;
    private String phoneNumber;
    private LocalDate birth;

    @Builder
    public AccountResDto(String name, String email, Gender gender, String phoneNumber, LocalDate birth) {
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.birth = birth;
    }


}
