package com.jb.CouponSystemSpring.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrMsg {
    NO_ID_FOUND("no ID found"),
    ID_ALREADY_EXISTS("the id is already inside the DB"),
    NAME_ALREADY_EXISTS("this name already exists"),
    EMAIL_ALREADY_EXISTS("this email already exists"),
    CANT_UPDATE_EMAIL("you can't update the email"),
    NO_CLIENT_SUPPORTED("no such client type"),
    CANT_CREATE_ADMIN("you can't register as admin"),
    EMAIL_OR_PASSWORD_INCORRECT("email or password are incorrect"),
    INCORRECT_EMAIL("email is incorrect"),
    INCORRECT_PASSWORD("password is incorrect"),
    INCORRECT_TOKEN("token is incorrect"),
    DUPLICATE_TITLE("you can't add a coupon with the same title"),
    ID_MISMATCH("the coupon you want to update does not match to the one inside the DB"),
    CANT_PURCHASE_TWICE("you can't buy the same coupon twice"),
    OUT_OF_STOCK("this coupon is out of stock"),
    EXPIRED("this coupon is expired"),
    NO_OWNERSHIP("you don't own this coupon");

    private final String message;
}
