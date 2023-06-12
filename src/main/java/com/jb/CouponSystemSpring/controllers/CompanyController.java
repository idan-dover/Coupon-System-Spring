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
    private CompanyService companyService;

    @PostMapping("/{token}/coupon")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCoupon(@PathVariable UUID token, @RequestBody Coupon coupon) throws CouponException {
        companyService.addCoupon(token, coupon);
    }

    @PutMapping("/{token}/coupon")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCoupon(@PathVariable UUID token, @RequestParam int val, @RequestBody Coupon coupon) throws CouponException {
        companyService.updateCoupon(token, val, coupon);
    }


    @GetMapping("/{token}")
    public Company getDetails(@PathVariable UUID token) throws CouponException {
        return companyService.getDetails(token);
    }

    @DeleteMapping("/{token}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCoupon(@PathVariable UUID token, @RequestParam int val) throws CouponException {
        companyService.deleteCoupon(token, val);
    }

    @GetMapping("/{token}/coupon")
    public List<Coupon> getAllCoupons(@PathVariable UUID token) throws CouponException {
        return companyService.getAllCoupons(token);
    }

    @GetMapping("/{token}/coupon/category")
    public List<Coupon> getAllCoupons(@PathVariable UUID token, @RequestParam Category val) throws CouponException {
        return companyService.getAllCoupons(token, val);
    }

    @GetMapping("/{token}/coupon/price")
    public List<Coupon> getAllCoupons(@PathVariable UUID token, @RequestParam double val) throws CouponException {
        return companyService.getAllCoupons(token, val);
    }


}
