package com.jb.CouponSystemSpring.Exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrMsg {
    NO_ID_FOUND("LOL😹 no ID found"),
    ID_ALREADY_EXISTS("LOL😹 the id is already inside the DB"),
    NAME_ALREADY_EXISTS("LOL😹 the name already exists in the DB"),
    EMAIL_ALREADY_EXISTS("LOL😹 the email already exists in the DB"),
    CANT_UPDATE_EMAIL("LOL😹 you can't update the email"), NO_CLIENT_SUPPORTED("LOL😹 no such client type");

    private final String message;
}
