package com.hwhy.moommoo.domain.account.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AuthenticationResDto {
    private final String jwt;
}
