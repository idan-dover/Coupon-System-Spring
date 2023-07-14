package com.jb.CouponSystemSpring.security;

import com.jb.CouponSystemSpring.exceptions.CouponException;
import com.jb.CouponSystemSpring.models.ClientType;
import com.jb.CouponSystemSpring.models.LoginResponse;

import java.util.UUID;

public interface TokenService {

    LoginResponse addToken(int id, ClientType clientType);

    boolean isUserAllowed(UUID token, ClientType type) throws CouponException;

    Information getUserInfo(UUID token, ClientType type);

    int validate(UUID token, ClientType type) throws CouponException;

    void clear(int timeToClear);

}
