package com.hwhy.moommoo.domain.account.entity;

import com.hwhy.moommoo.global.code.Gender;
import com.hwhy.moommoo.global.entity.BaseTimeEntity;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
public class Account extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accout_idx")
    private Long idx;

    @Column(name = "account_name", nullable = false)
    private String name;

    @Column(name = "account_email", nullable = false, unique = true)
    private String email;

    @Column(name = "account_password", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "account_gender", nullable = false)
    private Gender gender;

    @Column(name = "accout_birthdayDate", nullable = false)
    private LocalDate birthdayDate;


}
