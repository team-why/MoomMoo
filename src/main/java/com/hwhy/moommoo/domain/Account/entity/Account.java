package com.hwhy.moommoo.domain.Account.entity;

import com.hwhy.moommoo.domain.Account.dto.AccountResDto;
import com.hwhy.moommoo.global.code.Authority;
import com.hwhy.moommoo.global.code.Gender;
import com.hwhy.moommoo.global.entity.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Entity
@NoArgsConstructor
public class Account extends BaseTimeEntity {

    @Id
    @Column(name = "Account_idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    private String name;

    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String phoneNumber;

    private LocalDate birth;

    @Enumerated(EnumType.STRING)
    private Authority authority;

    @Builder
    public Account(String name, String email, String password, Gender gender, String phoneNumber, LocalDate birth, Authority authority) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.birth = birth;
        this.authority = authority;
    }


    public AccountResDto toResDto() {
        return AccountResDto.builder()
                .name(this.getName())
                .email(this.getEmail())
                .gender(this.getGender())
                .phoneNumber(this.getPhoneNumber())
                .birth(this.getBirth())
                .build();
    }

}
