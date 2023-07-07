package com.jb.CouponSystemSpring.services;

import com.jb.CouponSystemSpring.repository.CompanyRepository;
import com.jb.CouponSystemSpring.repository.CouponRepository;
import com.jb.CouponSystemSpring.repository.CustomerRepository;
import com.jb.CouponSystemSpring.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class ClientService {


    @Autowired
    protected CompanyRepository companyRepo;

    @Autowired
    protected CustomerRepository customerRepo;

    @Autowired
    protected CouponRepository couponRepo;

    @Autowired
    protected TokenService tokenService;


}
