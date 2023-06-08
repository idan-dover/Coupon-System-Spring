package com.jb.CouponSystemSpring.services;

import com.jb.CouponSystemSpring.Exceptions.CouponException;
import com.jb.CouponSystemSpring.Exceptions.ErrMsg;
import com.jb.CouponSystemSpring.beans.Client;
import com.jb.CouponSystemSpring.beans.ClientType;
import com.jb.CouponSystemSpring.beans.Company;
import com.jb.CouponSystemSpring.beans.Customer;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AuthServiceImpl extends ClientService implements AuthService {


    @Override
    public void register(Client client) throws CouponException {
        ClientType type = client.getClientType();
        if (type.equals(ClientType.ADMIN)) {
            throw new CouponException(ErrMsg.CANT_CREATE_ADMIN);
        }

        switch (type) {
            case COMPANY -> registerAsCompany(client);
            case CUSTOMER -> registerAsCustomer(client);
        }

    }

    private void registerAsCompany(Client client) throws CouponException {
        if (companyRepo.existsByEmail(client.getEmail())) {
            throw new CouponException(ErrMsg.EMAIL_ALREADY_EXISTS);
        }

        Company company = Company.builder()
                .name(client.getName())
                .email(client.getEmail())
                .password(client.getPassword())
                .build();

        companyRepo.save(company);
    }

    private void registerAsCustomer(Client client) throws CouponException {
        if (customerRepo.existsByEmail(client.getEmail())) {
            throw new CouponException(ErrMsg.EMAIL_ALREADY_EXISTS);
        }

        Customer customer = Customer.builder()
                .firstName(client.getFirstName())
                .lastName(client.getLastName())
                .email(client.getEmail())
                .password(client.getPassword())
                .build();

        customerRepo.save(customer);
    }

    @Override
    public UUID login(Client client) throws CouponException {
        ClientType type = client.getClientType();
        switch (type) {
            case COMPANY -> {
                return loginAsCompany(client);
            }

            case CUSTOMER -> {
                return loginAsCustomer(client);
            }
        }
        return null;
    }

    private UUID loginAsCompany(Client client) throws CouponException {
        if (!companyRepo.existsByEmailAndPassword(client.getEmail(), client.getPassword())) {
            throw new CouponException(ErrMsg.EMAIL_OR_PASSWORD_INCORRECT);
        }

        int id = companyRepo.findIdByEmail(client.getEmail());

        return tokenService.addToken(id,ClientType.COMPANY);
    }

    private UUID loginAsCustomer(Client client) throws CouponException {
        if (!customerRepo.existsByEmailAndPassword(client.getEmail(), client.getPassword())) {
            throw new CouponException(ErrMsg.EMAIL_OR_PASSWORD_INCORRECT);
        }

        int id = customerRepo.findIdByEmail(client.getEmail());

        return tokenService.addToken(id,ClientType.CUSTOMER);
    }


}
