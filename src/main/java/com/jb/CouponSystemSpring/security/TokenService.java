package com.jb.CouponSystemSpring.security;

import com.jb.CouponSystemSpring.beans.ClientType;

import java.util.UUID;

public interface TokenService {

    UUID addToken(int id, ClientType clientType);

    boolean isUserAllowed(UUID token, ClientType type);

    void clear();

}
