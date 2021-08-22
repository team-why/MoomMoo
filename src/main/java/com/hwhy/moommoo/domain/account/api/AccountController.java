package com.hwhy.moommoo.domain.account.api;

import com.hwhy.moommoo.config.jwt.JwtUtilService;
import com.hwhy.moommoo.domain.account.dto.request.AccountCreateReqDto;
import com.hwhy.moommoo.domain.account.dto.request.AuthenticationReqDto;
import com.hwhy.moommoo.domain.account.dto.response.AuthenticationResDto;
import com.hwhy.moommoo.domain.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtilService jwtUtilService;



    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@Valid AccountCreateReqDto accountCreateReqDto) {
        log.info("controller start");
        accountService.save(accountCreateReqDto);
        return ResponseEntity.ok("정상적으로 회원가입 완료.");
    }

//    @GetMapping(value = "/logout")
//    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
//        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
//        return "redirect:/login";
//    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(
            @RequestBody AuthenticationReqDto authenticationRequestDto) throws Exception {
        Authentication authentication;
        try {
            // 인증처리
            authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequestDto.getEmail(), authenticationRequestDto.getPassword()));
        } catch (BadCredentialsException e) {
            throw new Exception("아이디 또는 비밀번호가 적절하지 않습니다.", e);
        }

        final UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        final String jwt = jwtUtilService.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResDto(jwt));
    }


}
