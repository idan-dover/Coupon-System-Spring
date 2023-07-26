package com.jb.CouponSystemSpring.services;

import com.jb.CouponSystemSpring.exceptions.CouponException;
import com.jb.CouponSystemSpring.models.LoginResponse;
import com.jb.CouponSystemSpring.models.RegisterRequest;
import com.jb.CouponSystemSpring.models.RegisterResponse;
import com.jb.CouponSystemSpring.models.User;

public interface AuthService {

    RegisterResponse register(RegisterRequest registerReq) throws CouponException;

    LoginResponse login(User user) throws CouponException;
}