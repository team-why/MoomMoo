package com.hwhy.moommoo.domain.account.service;

import com.hwhy.moommoo.domain.account.dao.AccountRepository;
import com.hwhy.moommoo.domain.account.dto.AccountCreateReqDto;
import com.hwhy.moommoo.domain.account.entity.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService implements UserDetailsService {

    private final AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return accountRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException((email)));
    }

    public Long save(AccountCreateReqDto accountCreateReqDto) {
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
