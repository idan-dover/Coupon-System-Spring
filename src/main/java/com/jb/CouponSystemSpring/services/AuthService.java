package com.jb.CouponSystemSpring.services;

import com.jb.CouponSystemSpring.Exceptions.CouponException;
import com.jb.CouponSystemSpring.beans.User;

import java.util.UUID;

public interface AuthService {

    void register(User user) throws CouponException;
    UUID login(User user) throws CouponException;
}