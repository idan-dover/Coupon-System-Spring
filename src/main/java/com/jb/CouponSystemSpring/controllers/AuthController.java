package com.jb.CouponSystemSpring.controllers;

import com.jb.CouponSystemSpring.Exceptions.CouponException;
import com.jb.CouponSystemSpring.beans.Client;
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

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestBody Client client) throws CouponException {
        authService.register(client);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.CREATED)
    public UUID loginAsCompany(@RequestBody Client client) throws CouponException{
        return authService.login(client);
    }

}
