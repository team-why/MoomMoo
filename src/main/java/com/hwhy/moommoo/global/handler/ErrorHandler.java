package com.hwhy.moommoo.global.handler;

import com.hwhy.moommoo.global.exception.JsonException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(value = JsonException.class)
    @ResponseBody
    public ApiHandler jsonErrorHandler(JsonException exception) {
        return ApiHandler.ofException(exception);
    }

}
