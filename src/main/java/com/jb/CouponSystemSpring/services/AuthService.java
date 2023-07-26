package com.jb.CouponSystemSpring.services;

import com.jb.CouponSystemSpring.exceptions.CouponException;
import com.jb.CouponSystemSpring.models.LoginResponse;
import com.jb.CouponSystemSpring.models.Register;
import com.jb.CouponSystemSpring.models.User;

public interface AuthService {

    User register(Register register) throws CouponException;

    LoginResponse login(User user) throws CouponException;
}