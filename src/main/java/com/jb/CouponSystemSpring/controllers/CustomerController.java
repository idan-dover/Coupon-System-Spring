package com.jb.CouponSystemSpring.controllers;

import com.jb.CouponSystemSpring.beans.Category;
import com.jb.CouponSystemSpring.beans.Coupon;
import com.jb.CouponSystemSpring.beans.Customer;
import com.jb.CouponSystemSpring.exceptions.CouponException;
import com.jb.CouponSystemSpring.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PutMapping("/{customerId}/coupon/purchase/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void purchase(@PathVariable int customerId, @PathVariable int id) throws CouponException {
        customerService.purchaseCoupon(customerId, id);
    }

    @GetMapping("/{customerId}/coupon/purchase")
    public List<Coupon> getUnsoldCoupons(@PathVariable int customerId) throws CouponException {
        return customerService.getUnsoldCoupons(customerId);
    }

    @GetMapping("/{customerId}/coupon")
    public List<Coupon> getAllCoupons(@PathVariable int customerId) throws CouponException {
        return customerService.getAllCoupons(customerId);
    }

    @GetMapping("/{customerId}/coupon/category")
    public List<Coupon> getAllCoupons(@PathVariable int customerId, @RequestParam Category val) throws CouponException {
        return customerService.getAllCoupons(customerId, val);
    }

    @GetMapping("/{customerId}/coupon/price")
    public List<Coupon> getAllCoupons(@PathVariable int customerId, @RequestParam double val) throws CouponException {
        return customerService.getAllCoupons(customerId, val);
    }

    @GetMapping("/{customerId}")
    public Customer getDetails(@PathVariable int customerId) throws CouponException {
        return customerService.getDetails(customerId);
    }
}
