package com.hwhy.moommoo.global.exception;

import lombok.Getter;

@Getter
public enum Status {
    OK(200, "성공"),
    UNKNOWN(500, "서버 에러");

    private Integer code;
    private String message;

    Status(Integer code, String message){
        this.code = code;
        this.message = message;
    }
}
