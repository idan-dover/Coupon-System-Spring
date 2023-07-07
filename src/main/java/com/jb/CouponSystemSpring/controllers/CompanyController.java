package com.jb.CouponSystemSpring.controllers;

import com.jb.CouponSystemSpring.Exceptions.CouponException;
import com.jb.CouponSystemSpring.beans.Category;
import com.jb.CouponSystemSpring.beans.Company;
import com.jb.CouponSystemSpring.beans.Coupon;
import com.jb.CouponSystemSpring.models.ClientType;
import com.jb.CouponSystemSpring.security.TokenService;
import com.jb.CouponSystemSpring.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/company")
public class CompanyController {
    // TODO: 07/07/2023 make the service receive id and validate token here
    @Autowired
    private CompanyService companyService;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/coupon")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCoupon(@RequestHeader("Authorization") UUID token,
                          @RequestBody Coupon coupon) throws CouponException {
        int companyId = tokenService.validate(token, ClientType.COMPANY);
        companyService.addCoupon(companyId, coupon);
    }

    @PutMapping("/coupon/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCoupon(@RequestHeader("Authorization") UUID token,
                             @PathVariable int id,
                             @RequestBody Coupon coupon) throws CouponException {
        int companyId = tokenService.validate(token, ClientType.COMPANY);
        companyService.updateCoupon(companyId, id, coupon);
    }


    @GetMapping
    public Company getDetails(@RequestHeader("Authorization") UUID token) throws CouponException {
        int companyId = tokenService.validate(token, ClientType.COMPANY);
        return companyService.getDetails(companyId);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCoupon(@RequestHeader("Authorization") UUID token,
                             @RequestParam int val) throws CouponException {
        int companyId = tokenService.validate(token, ClientType.COMPANY);
        companyService.deleteCoupon(companyId, val);
    }

    @GetMapping("/coupon")
    public List<Coupon> getAllCoupons(@RequestHeader("Authorization") UUID token) throws CouponException {
        int companyId = tokenService.validate(token, ClientType.COMPANY);
        return companyService.getAllCoupons(companyId);
    }

    @GetMapping("/coupon/category")
    public List<Coupon> getAllCoupons(@RequestHeader("Authorization") UUID token,
                                      @RequestParam Category val) throws CouponException {
        int companyId = tokenService.validate(token, ClientType.COMPANY);
        return companyService.getAllCoupons(companyId, val);
    }

    @GetMapping("/coupon/price")
    public List<Coupon> getAllCoupons(@RequestHeader("Authorization") UUID token,
                                      @RequestParam double val) throws CouponException {
        int companyId = tokenService.validate(token, ClientType.COMPANY);
        return companyService.getAllCoupons(companyId, val);
    }


}
