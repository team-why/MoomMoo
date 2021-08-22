package com.hwhy.moommoo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MoommooApplication {

    public static void main(String[] args) {
        SpringApplication.run(MoommooApplication.class, args);
    }

}

//oauth2/authorization/naver