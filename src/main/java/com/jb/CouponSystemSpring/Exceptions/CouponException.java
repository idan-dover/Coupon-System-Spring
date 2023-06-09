package com.jb.CouponSystemSpring.Exceptions;

public class CouponException extends Exception {

    public CouponException(ErrMsg errMsg) {
        super(errMsg.getMessage());
    }

}
