package com.jb.CouponSystemSpring.services;

import com.jb.CouponSystemSpring.beans.Company;
import com.jb.CouponSystemSpring.beans.Customer;
import com.jb.CouponSystemSpring.exceptions.CouponException;
import com.jb.CouponSystemSpring.exceptions.ErrMsg;
import com.jb.CouponSystemSpring.models.ClientType;
import com.jb.CouponSystemSpring.models.Register;
import com.jb.CouponSystemSpring.models.User;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AuthServiceImpl extends ClientService implements AuthService {

    @Override
    public void register(Register register) throws CouponException {
        ClientType type = register.getClientType();
        if (type.equals(ClientType.ADMIN)) {
            throw new CouponException(ErrMsg.CANT_CREATE_ADMIN);
        }

        switch (type) {
            case COMPANY -> registerAsCompany(register);
            case CUSTOMER -> registerAsCustomer(register);
        }

    }

    private void registerAsCompany(Register register) throws CouponException {
        if (companyRepo.existsByEmail(register.getEmail())) {
            throw new CouponException(ErrMsg.EMAIL_ALREADY_EXISTS);
        }

        Company company = Company.builder()
                .name((String) register.getParams().get("name"))
                .email(register.getEmail())
                .password(register.getPassword())
                .build();

        companyRepo.save(company);
    }

    private void registerAsCustomer(Register register) throws CouponException {
        if (customerRepo.existsByEmail(register.getEmail())) {
            throw new CouponException(ErrMsg.EMAIL_ALREADY_EXISTS);
        }

        Customer customer = Customer.builder()
                .firstName((String) register.getParams().get("firstName"))
                .lastName((String) register.getParams().get("lastName"))
                .email(register.getEmail())
                .password(register.getPassword())
                .build();

        customerRepo.save(customer);
    }

    @Override
    public UUID login(User user) throws CouponException {
        ClientType type = user.getClientType();
        switch (type) {
            case ADMIN -> {
                return loginAsAdmin(user);
            }
            case COMPANY -> {
                return loginAsCompany(user);
            }

            case CUSTOMER -> {
                return loginAsCustomer(user);
            }
        }
        return null;
    }

    private UUID loginAsAdmin(User user) throws CouponException {
        String adminEmail = "admin@admin.com";
        String adminPassword = "1234";

        if (!user.getEmail().equals(adminEmail) || !user.getPassword().equals(adminPassword)) {
            throw new CouponException(ErrMsg.EMAIL_OR_PASSWORD_INCORRECT);
        }

        return tokenService.addToken(0, ClientType.ADMIN);
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
