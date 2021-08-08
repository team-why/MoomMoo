package com.hwhy.moommoo.domain;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@EnableWebSecurity
@RestController
public class TestController {

    @GetMapping("/")
    public String test() {
        return "test" ;
    }
}
