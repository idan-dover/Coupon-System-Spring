package com.jb.CouponSystemSpring.controllers;

import com.jb.CouponSystemSpring.Exceptions.CouponException;
import com.jb.CouponSystemSpring.beans.Category;
import com.jb.CouponSystemSpring.beans.Coupon;
import com.jb.CouponSystemSpring.beans.Customer;
import com.jb.CouponSystemSpring.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    // TODO: 07/07/2023 fix REST api
    // TODO: 07/07/2023 make the service receive id and validate token here
    @Autowired
    private CustomerService customerService;

    @PutMapping("/coupon/purchase/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void purchase(@RequestHeader("Authorization") UUID token,
                         @PathVariable int id) throws CouponException {
        customerService.purchaseCoupon(token, id);
    }

    @GetMapping("/coupon")
    public List<Coupon> getAllCoupons(@RequestHeader("Authorization") UUID token) throws CouponException {
        return customerService.getAllCoupons(token);
    }

    @GetMapping("/coupon/category")
    public List<Coupon> getAllCoupons(@RequestHeader("Authorization") UUID token, @RequestParam Category val) throws CouponException {
        return customerService.getAllCoupons(token, val);
    }

    @GetMapping("/coupon/price")
    public List<Coupon> getAllCoupons(@RequestHeader("Authorization") UUID token, @RequestParam double val) throws CouponException {
        return customerService.getAllCoupons(token, val);
    }

    @GetMapping
    public Customer getDetails(@RequestHeader("Authorization") UUID token) throws CouponException {
        return customerService.getDetails(token);
    }
}
