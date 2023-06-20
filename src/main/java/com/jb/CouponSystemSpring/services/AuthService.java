package com.jb.CouponSystemSpring.services;

import com.jb.CouponSystemSpring.Exceptions.CouponException;
import com.jb.CouponSystemSpring.models.Register;
import com.jb.CouponSystemSpring.models.User;

import java.util.UUID;

public interface AuthService {

    void register(Register user) throws CouponException;

    UUID login(User user) throws CouponException;
}