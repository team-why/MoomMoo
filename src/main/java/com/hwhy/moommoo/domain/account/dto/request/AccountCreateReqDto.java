package com.hwhy.moommoo.domain.account.dto.request;

import com.hwhy.moommoo.global.code.Gender;
import com.hwhy.moommoo.global.entity.BaseTimeEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
public class AccountCreateReqDto {

    @NotNull
    private String name;

    @NotNull
    private String email;

    @NotNull
    private String password;

    @NotNull
    private Gender gender;

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate birthdayDate;

    @NotNull
    private String auth;

}
