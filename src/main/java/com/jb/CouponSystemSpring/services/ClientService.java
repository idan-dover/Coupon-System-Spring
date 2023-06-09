package com.jb.CouponSystemSpring.services;

import com.jb.CouponSystemSpring.beans.ClientType;
import com.jb.CouponSystemSpring.repository.CompanyRepository;
import com.jb.CouponSystemSpring.repository.CouponRepository;
import com.jb.CouponSystemSpring.repository.CustomerRepository;
import com.jb.CouponSystemSpring.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public abstract class ClientService {


    @Autowired
    CompanyRepository companyRepo;

    @Autowired
    CustomerRepository customerRepo;

    @Autowired
    CouponRepository couponRepo;

    @Autowired
    TokenService tokenService;


    public boolean login(UUID token, ClientType clientType) {
        return tokenService.isUserAllowed(token, clientType);
    }

    protected boolean convertLongToBoolean(Long res) {
        return res == 1;
    }

}
