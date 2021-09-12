package com.hwhy.moommoo.global.handler;

import com.hwhy.moommoo.global.exception.BaseException;
import com.hwhy.moommoo.global.exception.Status;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ApiHandler {
    private Integer code;
    private String message;
    private Object data;

    private ApiHandler(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static ApiHandler of(Integer code, String message, Object data) {
        return new ApiHandler(code, message, data);
    }

    public static ApiHandler ofSuccess(Object data) {
        return ofStatus(Status.OK, data);
    }

    public static ApiHandler ofMessage(String message) {
        return of(Status.OK.getCode(), message, null);
    }

    public static ApiHandler ofStatus(Status status) {
        return ofStatus(status, null);
    }

    public static ApiHandler ofStatus(Status status, Object data) {
        return of(status.getCode(), status.getMessage(), data);
    }

    public static <T extends BaseException> ApiHandler ofException(T t, Object data) {
        return of(t.getCode(), t.getMessage(), data);
    }

    public static <T extends BaseException> ApiHandler ofException(T t) {
        return ofException(t, null);
    }

}
