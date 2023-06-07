package com.jb.CouponSystemSpring.Exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrMsg {
    NO_ID_FOUND("no id found");

    private final String message;
}
