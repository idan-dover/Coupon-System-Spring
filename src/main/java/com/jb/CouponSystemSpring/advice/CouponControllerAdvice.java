package com.jb.CouponSystemSpring.advice;

import com.jb.CouponSystemSpring.Exceptions.CouponException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CouponControllerAdvice {

    @ExceptionHandler(value = {CouponException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrDetails handleException(Exception e) {
        return new ErrDetails(e.getMessage());
    }
}
