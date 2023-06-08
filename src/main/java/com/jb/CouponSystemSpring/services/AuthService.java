package com.jb.CouponSystemSpring.services;

import com.jb.CouponSystemSpring.Exceptions.CouponException;
import com.jb.CouponSystemSpring.beans.Client;
import com.jb.CouponSystemSpring.beans.ClientType;

import java.util.UUID;

public interface AuthService {

    void register(Client client) throws CouponException;
    UUID login(Client client) throws CouponException;
}