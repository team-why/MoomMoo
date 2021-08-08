package com.hwhy.moommoo.global.code;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Gender implements MoomMooEnumerable{
    MALE(0),
    FEMALE(1)
    ;

    private final int value;


    @Override
    public int getValue() {
        return value;
    }

    @Override
    public String getKey() {
        return name();
    }
}
