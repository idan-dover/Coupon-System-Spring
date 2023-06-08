package com.jb.CouponSystemSpring.services;

import com.jb.CouponSystemSpring.repository.CompanyRepository;
import com.jb.CouponSystemSpring.repository.CouponRepository;
import com.jb.CouponSystemSpring.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class ClientService {

    @Autowired
    CompanyRepository companyRepo;

    @Autowired
    CustomerRepository customerRepo;

    @Autowired
    CouponRepository couponRepo;

}
