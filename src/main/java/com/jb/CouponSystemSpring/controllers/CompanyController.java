package com.jb.CouponSystemSpring.controllers;

import com.jb.CouponSystemSpring.Exceptions.CouponException;
import com.jb.CouponSystemSpring.beans.Category;
import com.jb.CouponSystemSpring.beans.Company;
import com.jb.CouponSystemSpring.beans.Coupon;
import com.jb.CouponSystemSpring.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/company")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @PostMapping("/coupon")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCoupon(@RequestHeader("token") UUID token, @RequestBody Coupon coupon) throws CouponException {
        companyService.addCoupon(token, coupon);
    }

    @PutMapping("/coupon")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCoupon(@RequestHeader("token") UUID token, @RequestParam int val, @RequestBody Coupon coupon) throws CouponException {
        companyService.updateCoupon(token, val, coupon);
    }


    @GetMapping
    public Company getDetails(@RequestHeader("token") UUID token) throws CouponException {
        return companyService.getDetails(token);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCoupon(@RequestHeader("token") UUID token, @RequestParam int val) throws CouponException {
        companyService.deleteCoupon(token, val);
    }

    @GetMapping("/coupon")
    public List<Coupon> getAllCoupons(@RequestHeader("token") UUID token) throws CouponException {
        return companyService.getAllCoupons(token);
    }

    @GetMapping("/coupon/category")
    public List<Coupon> getAllCoupons(@RequestHeader("token") UUID token, @RequestParam Category val) throws CouponException {
        return companyService.getAllCoupons(token, val);
    }

    @GetMapping("/coupon/price")
    public List<Coupon> getAllCoupons(@RequestHeader("token") UUID token, @RequestParam double val) throws CouponException {
        return companyService.getAllCoupons(token, val);
    }


}
