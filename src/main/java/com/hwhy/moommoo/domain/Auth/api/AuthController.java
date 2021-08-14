package com.hwhy.moommoo.domain.Auth.api;

import com.hwhy.moommoo.domain.Account.dto.AccountReqDto;
import com.hwhy.moommoo.domain.Account.dto.AccountResDto;
import com.hwhy.moommoo.global.security.jwt.dto.TokenDto;
import com.hwhy.moommoo.global.security.jwt.dto.TokenRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<AccountResDto> signUp(@RequestBody AccountReqDto accountReqDto) {
        return ResponseEntity.ok(authService.signUp(accountReqDto));
    }

    @PostMapping("/login")
    public ResponseEntity<TokenDto> login(@RequestBody AccountReqDto accountReqDto) {
        return ResponseEntity.ok(authService.login(accountReqDto));
    }

    @PostMapping("/reissue")
    public ResponseEntity<TokenDto> reIssue(@RequestBody TokenRequestDto tokenRequestDto) {
        return ResponseEntity.ok(authService.reissue(tokenRequestDto));
    }

}
