package com.jb.CouponSystemSpring.services;

import com.jb.CouponSystemSpring.Exceptions.CouponException;
import com.jb.CouponSystemSpring.Exceptions.ErrMsg;
import com.jb.CouponSystemSpring.beans.ClientType;
import com.jb.CouponSystemSpring.beans.Company;
import com.jb.CouponSystemSpring.beans.Customer;
import com.jb.CouponSystemSpring.models.Register;
import com.jb.CouponSystemSpring.models.User;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AuthServiceImpl extends ClientService implements AuthService {


    @Override
    public void register(Register user) throws CouponException {
        ClientType type = user.getClientType();
        if (type.equals(ClientType.ADMIN)) {
            throw new CouponException(ErrMsg.CANT_CREATE_ADMIN);
        }

        switch (type) {
            case COMPANY -> registerAsCompany(user);
            case CUSTOMER -> registerAsCustomer(user);
        }

    }

    private void registerAsCompany(Register user) throws CouponException {
        if (companyRepo.existsByEmail(user.getEmail())) {
            throw new CouponException(ErrMsg.EMAIL_ALREADY_EXISTS);
        }

        Company company = Company.builder()
                .name((String) user.getParams().get("name"))
                .email(user.getEmail())
                .password(user.getPassword())
                .build();

        companyRepo.save(company);
    }

    private void registerAsCustomer(Register user) throws CouponException {
        if (customerRepo.existsByEmail(user.getEmail())) {
            throw new CouponException(ErrMsg.EMAIL_ALREADY_EXISTS);
        }

        Customer customer = Customer.builder()
                .firstName((String) user.getParams().get("firstName"))
                .lastName((String) user.getParams().get("lastName"))
                .email(user.getEmail())
                .password(user.getPassword())
                .build();

        customerRepo.save(customer);
    }

    @Override
    public UUID login(User user) throws CouponException {
        ClientType type = user.getClientType();
        switch (type) {
            case COMPANY -> {
                return loginAsCompany(user);
            }

            case CUSTOMER -> {
                return loginAsCustomer(user);
            }
        }
        return null;
    }

    private UUID loginAsCompany(User user) throws CouponException {
        if (!companyRepo.existsByEmailAndPassword(user.getEmail(), user.getPassword())) {
            throw new CouponException(ErrMsg.EMAIL_OR_PASSWORD_INCORRECT);
        }

        int id = companyRepo.findIdByEmail(user.getEmail());

        return tokenService.addToken(id, ClientType.COMPANY);
    }

    private UUID loginAsCustomer(User user) throws CouponException {
        if (!customerRepo.existsByEmailAndPassword(user.getEmail(), user.getPassword())) {
            throw new CouponException(ErrMsg.EMAIL_OR_PASSWORD_INCORRECT);
        }

        int id = customerRepo.findIdByEmail(user.getEmail());

        return tokenService.addToken(id, ClientType.CUSTOMER);
    }


}
