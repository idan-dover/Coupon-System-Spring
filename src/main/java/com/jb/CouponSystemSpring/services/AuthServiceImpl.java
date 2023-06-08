package com.jb.CouponSystemSpring.services;

import com.jb.CouponSystemSpring.Exceptions.CouponException;
import com.jb.CouponSystemSpring.Exceptions.ErrMsg;
import com.jb.CouponSystemSpring.beans.ClientType;
import com.jb.CouponSystemSpring.beans.Company;
import com.jb.CouponSystemSpring.beans.Customer;

import java.util.UUID;

public class AuthServiceImpl extends ClientService implements AuthService {


    @Override
    public void register(String email, ClientType clientType) throws CouponException {
        if (clientType.equals(ClientType.ADMIN)) {
            throw new CouponException(ErrMsg.CANT_CREATE_ADMIN);
        }

        switch (clientType) {
            case COMPANY -> registerAsCompany(email);
            case CUSTOMER -> registerAsCustomer(email);
        }

    }

    private void registerAsCompany(String email) throws CouponException {
        Company company = companyRepo.findByEmail(email)
                .orElseThrow(() -> new CouponException(ErrMsg.NO_ID_FOUND));

        if (companyRepo.existsByEmail(company.getEmail())) {
            throw new CouponException(ErrMsg.EMAIL_ALREADY_EXISTS);
        }

        companyRepo.save(company);
    }

    private void registerAsCustomer(String email) throws CouponException {
        Customer customer = customerRepo.findByEmail(email)
                .orElseThrow(() -> new CouponException(ErrMsg.NO_ID_FOUND));

        if (customerRepo.existsByEmail(customer.getEmail())) {
            throw new CouponException(ErrMsg.EMAIL_ALREADY_EXISTS);
        }

        customerRepo.save(customer);
    }

    @Override
    public UUID login(String email, String password, ClientType clientType) throws CouponException {
        switch (clientType) {
            case COMPANY -> {
                return loginAsCompany(email, password);
            }

            case CUSTOMER -> {
                return loginAsCustomer(email,password);
            }
        }
        return null;
    }

    private UUID loginAsCompany(String email, String password) throws CouponException {
        if (!companyRepo.existsByEmailAndPassword(email,password)) {
            throw new CouponException(ErrMsg.EMAIL_OR_PASSWORD_INCORRECT);
        }

        int id = companyRepo.findIdByEmail(email);

        return tokenService.addToken(id,ClientType.COMPANY);
    }

    private UUID loginAsCustomer(String email, String password) throws CouponException {
        if (!customerRepo.existsByEmailAndPassword(email,password)) {
            throw new CouponException(ErrMsg.EMAIL_OR_PASSWORD_INCORRECT);
        }

        int id = customerRepo.findIdByEmail(email);

        return tokenService.addToken(id,ClientType.CUSTOMER);
    }


}
