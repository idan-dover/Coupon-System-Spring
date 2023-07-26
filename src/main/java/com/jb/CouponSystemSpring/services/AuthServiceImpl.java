package com.jb.CouponSystemSpring.services;

import com.jb.CouponSystemSpring.beans.Company;
import com.jb.CouponSystemSpring.beans.Customer;
import com.jb.CouponSystemSpring.exceptions.CouponException;
import com.jb.CouponSystemSpring.exceptions.ErrMsg;
import com.jb.CouponSystemSpring.models.*;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl extends ClientService implements AuthService {

    @Override
    public RegisterResponse register(RegisterRequest registerReq) throws CouponException {
        ClientType type = registerReq.getClientType();
        if (type.equals(ClientType.ADMIN)) {
            throw new CouponException(ErrMsg.CANT_CREATE_ADMIN);
        }

        if (companyRepo.existsByEmail(registerReq.getEmail())) {
            throw new CouponException(ErrMsg.EMAIL_ALREADY_EXISTS);
        }

        if (customerRepo.existsByEmail(registerReq.getEmail())) {
            throw new CouponException(ErrMsg.EMAIL_ALREADY_EXISTS);
        }

        if (type.equals(ClientType.COMPANY)) {
            Company company = Company.builder()
                    .name((String) registerReq.getParams().get("name"))
                    .email(registerReq.getEmail())
                    .password(registerReq.getPassword())
                    .build();

            companyRepo.save(company);
        }

        if (type.equals(ClientType.CUSTOMER)) {
            Customer customer = Customer.builder()
                    .firstName((String) registerReq.getParams().get("firstName"))
                    .lastName((String) registerReq.getParams().get("lastName"))
                    .email(registerReq.getEmail())
                    .password(registerReq.getPassword())
                    .build();

            customerRepo.save(customer);
        }

        return RegisterResponse.builder()
                .email(registerReq.getEmail())
                .password(registerReq.getPassword())
                .clientType(type)
                .build();
    }
    
    @Override
    public LoginResponse login(User user) throws CouponException {

        if (user.getEmail().equals("admin@admin.com") && user.getPassword().equals("1234")) {
            return tokenService.addToken(0, ClientType.ADMIN);
        }

        if (companyRepo.existsByEmailAndPassword(user.getEmail(), user.getPassword())) {
            int id = companyRepo.findIdByEmail(user.getEmail());
            return tokenService.addToken(id, ClientType.COMPANY);
        }

        if (customerRepo.existsByEmailAndPassword(user.getEmail(), user.getPassword())) {
            int id = customerRepo.findIdByEmail(user.getEmail());
            return tokenService.addToken(id, ClientType.CUSTOMER);
        }

        throw new CouponException(ErrMsg.EMAIL_OR_PASSWORD_INCORRECT);
    }

}
