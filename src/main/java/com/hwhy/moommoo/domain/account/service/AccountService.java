package com.hwhy.moommoo.domain.account.service;

import com.hwhy.moommoo.domain.account.dao.AccountRepository;
import com.hwhy.moommoo.domain.account.dto.request.AccountCreateReqDto;
import com.hwhy.moommoo.domain.account.entity.Account;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountService {

    private final AccountRepository accountRepository;

    public Long save(AccountCreateReqDto accountCreateReqDto) {
        log.info("service start");
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        accountCreateReqDto.setPassword(encoder.encode(accountCreateReqDto.getPassword()));

        return accountRepository.save(
                Account.builder()
                        .name(accountCreateReqDto.getName())
                        .email(accountCreateReqDto.getEmail())
                        .password(accountCreateReqDto.getPassword())
                        .gender(accountCreateReqDto.getGender())
                        .birthdayDate(accountCreateReqDto.getBirthdayDate())
                        .auth(accountCreateReqDto.getAuth())
                        .build())
                .getIdx();
    }
}
