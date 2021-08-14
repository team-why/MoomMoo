package com.hwhy.moommoo.domain.Account.service;

import com.hwhy.moommoo.domain.Account.dao.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;



}
