package com.jb.CouponSystemSpring.exceptions;

public class CouponException extends Exception {

    public CouponException(ErrMsg errMsg) {
        super(errMsg.getMessage());
    }

}
