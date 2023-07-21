package com.jb.CouponSystemSpring.security;

import com.jb.CouponSystemSpring.models.ClientType;
import com.jb.CouponSystemSpring.models.LoginResponse;

import java.util.UUID;

public interface TokenService {

    LoginResponse addToken(int id, ClientType clientType);

    boolean validate(UUID token, ClientType type);

    Information getUserInfo(UUID token);

    void clear(int timeToClear);

}
