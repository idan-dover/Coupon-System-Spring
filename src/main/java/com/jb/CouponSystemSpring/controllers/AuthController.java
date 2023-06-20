package com.jb.CouponSystemSpring.controllers;

import com.jb.CouponSystemSpring.Exceptions.CouponException;
import com.jb.CouponSystemSpring.models.User;
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
    public void register(@RequestBody User user) throws CouponException {
        authService.register(user);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.CREATED)
    public UUID login(@RequestBody User user) throws CouponException {
        return authService.login(user);
    }

}
