package com.hwhy.moommoo.config.jwt;

import com.hwhy.moommoo.domain.account.dao.AccountRepository;
import com.hwhy.moommoo.domain.account.entity.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Optional<Account> optAccount = accountRepository.findByEmail(email);
        Account account =  optAccount.get();

        return new User(account.getEmail(), account.getPassword(), new ArrayList<>());
    }
}
