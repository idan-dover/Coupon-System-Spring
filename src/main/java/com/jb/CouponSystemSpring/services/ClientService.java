package com.jb.CouponSystemSpring.services;

import com.jb.CouponSystemSpring.Exceptions.CouponException;
import com.jb.CouponSystemSpring.Exceptions.ErrMsg;
import com.jb.CouponSystemSpring.models.ClientType;
import com.jb.CouponSystemSpring.repository.CompanyRepository;
import com.jb.CouponSystemSpring.repository.CouponRepository;
import com.jb.CouponSystemSpring.repository.CustomerRepository;
import com.jb.CouponSystemSpring.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public abstract class ClientService {


    @Autowired
    protected CompanyRepository companyRepo;

    @Autowired
    protected CustomerRepository customerRepo;

    @Autowired
    protected CouponRepository couponRepo;

    @Autowired
    protected TokenService tokenService;


    protected void validateToken(UUID token, ClientType clientType) throws CouponException {
        if (!tokenService.isUserAllowed(token, clientType)) {
            throw new CouponException(ErrMsg.INCORRECT_TOKEN);
        }
    }

    protected int getClientId(UUID token, ClientType clientType) throws CouponException {
        validateToken(token, clientType);

        return tokenService.getUserInfo(token, clientType).getId();
    }

}
