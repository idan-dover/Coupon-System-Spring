package com.jb.CouponSystemSpring.services;

import com.jb.CouponSystemSpring.Exceptions.CouponException;
import com.jb.CouponSystemSpring.beans.ClientType;

import java.util.UUID;

public interface AuthService {

    void register(String email, ClientType clientType) throws CouponException;
    UUID login(String email, String password, ClientType clientType) throws CouponException;
}