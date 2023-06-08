package com.jb.CouponSystemSpring.controllers;

import com.jb.CouponSystemSpring.Exceptions.CouponException;
import com.jb.CouponSystemSpring.beans.ClientType;
import com.jb.CouponSystemSpring.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register/company")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerAsCompany(@RequestBody String email) throws CouponException {
        authService.register(email, ClientType.COMPANY);
    }

    @PostMapping("/login/company")
    @ResponseStatus(HttpStatus.CREATED)
    public UUID loginAsCompany(@RequestBody String email,String password) throws CouponException{
        return authService.login(email,password,ClientType.COMPANY);
    }

    @PostMapping("/register/customer")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerAsCustomer(@RequestBody String email) throws CouponException {
        authService.register(email, ClientType.CUSTOMER);
    }

    @PostMapping("/login/customer")
    @ResponseStatus(HttpStatus.CREATED)
    public UUID loginAsCustomer(@RequestBody String email,String password) throws CouponException{
        return authService.login(email,password,ClientType.CUSTOMER);
    }
}
