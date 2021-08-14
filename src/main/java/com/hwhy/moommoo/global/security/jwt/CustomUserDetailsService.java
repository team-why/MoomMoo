package com.hwhy.moommoo.global.security.jwt;

import com.hwhy.moommoo.domain.Account.dao.AccountRepository;
import com.hwhy.moommoo.domain.Account.entity.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;

//@Service
//@RequiredArgsConstructor
//public class CustomUserDetailsService implements UserDetailsService {
//
//    private final AccountRepository accountRepository;
//
//    @Override
//    @Transactional
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return accountRepository.findByEmail(username)
//                .map(this::createUserDetails)
//                .orElseThrow(() -> new UsernameNotFoundException(username + " -> 데이터베이스에서 찾을 수 없습니다."));
//    }
////
//    // DB 에 User 값이 존재한다면 UserDetails 객체로 만들어서 리턴
//    private UserDetails createUserDetails(Account account) {
//        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(account.getAuthority().toString());
//
//        return new Account(
//                account.getName(),
//                account.getEmail(),
//                account.getPassword(),
//                account.getGender(),
//                account.getPhoneNumber(),
//                account.getBirth(),
//                account.getAuthority());
//
//        );
//    }
//}