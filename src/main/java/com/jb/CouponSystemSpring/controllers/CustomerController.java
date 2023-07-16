package com.jb.CouponSystemSpring.controllers;

import com.jb.CouponSystemSpring.beans.Category;
import com.jb.CouponSystemSpring.beans.Coupon;
import com.jb.CouponSystemSpring.beans.Customer;
import com.jb.CouponSystemSpring.exceptions.CouponException;
import com.jb.CouponSystemSpring.models.ClientType;
import com.jb.CouponSystemSpring.security.TokenService;
import com.jb.CouponSystemSpring.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private TokenService tokenService;

    @PutMapping("/coupon/purchase/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void purchase(@RequestHeader("Authorization") UUID token,
                         @PathVariable int id) throws CouponException {
        int customerId = tokenService.validate(token, ClientType.CUSTOMER);
        customerService.purchaseCoupon(customerId, id);
    }

    @GetMapping("/coupon/purchase")
    public List<Coupon> getUnsoldCoupons(@RequestHeader("Authorization") UUID token) throws CouponException {
        int customerId = tokenService.validate(token, ClientType.CUSTOMER);
        return customerService.getUnsoldCoupons(customerId);
    }

    @GetMapping("/coupon")
    public List<Coupon> getAllCoupons(@RequestHeader("Authorization") UUID token) throws CouponException {
        int customerId = tokenService.validate(token, ClientType.CUSTOMER);
        return customerService.getAllCoupons(customerId);
    }

    @GetMapping("/coupon/category")
    public List<Coupon> getAllCoupons(@RequestHeader("Authorization") UUID token,
                                      @RequestParam Category val) throws CouponException {
        int customerId = tokenService.validate(token, ClientType.CUSTOMER);
        return customerService.getAllCoupons(customerId, val);
    }

    @GetMapping("/coupon/price")
    public List<Coupon> getAllCoupons(@RequestHeader("Authorization") UUID token,
                                      @RequestParam double val) throws CouponException {
        int customerId = tokenService.validate(token, ClientType.CUSTOMER);
        return customerService.getAllCoupons(customerId, val);
    }

    @GetMapping
    public Customer getDetails(@RequestHeader("Authorization") UUID token) throws CouponException {
        int customerId = tokenService.validate(token, ClientType.CUSTOMER);
        return customerService.getDetails(customerId);
    }
}
