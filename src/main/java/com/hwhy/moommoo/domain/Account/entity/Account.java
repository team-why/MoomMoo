package com.hwhy.moommoo.domain.Account.entity;

import com.hwhy.moommoo.domain.Account.dto.AccountResDto;
import com.hwhy.moommoo.global.code.Authority;
import com.hwhy.moommoo.global.code.Gender;
import com.hwhy.moommoo.global.entity.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Getter
@Entity
@NoArgsConstructor
public class Account extends BaseTimeEntity implements UserDetails {

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
    private String authority;

    @Builder
    public Account(String name, String email, String password, Gender gender, String phoneNumber, LocalDate birth, String authority) {
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> roles = new HashSet<>();
        for (String role : authority.split(",")) {
            roles.add(new SimpleGrantedAuthority(role));
        }
        return roles;    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
