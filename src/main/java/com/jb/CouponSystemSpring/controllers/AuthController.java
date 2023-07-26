package com.jb.CouponSystemSpring.controllers;

import com.jb.CouponSystemSpring.exceptions.CouponException;
import com.jb.CouponSystemSpring.models.LoginResponse;
import com.jb.CouponSystemSpring.models.RegisterRequest;
import com.jb.CouponSystemSpring.models.RegisterResponse;
import com.jb.CouponSystemSpring.models.User;
import com.jb.CouponSystemSpring.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public RegisterResponse register(@RequestBody RegisterRequest registerReq) throws CouponException {
        return authService.register(registerReq);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.CREATED)
    public LoginResponse login(@RequestBody User user) throws CouponException {
        return authService.login(user);
    }

}
