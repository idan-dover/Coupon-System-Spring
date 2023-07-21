package com.jb.CouponSystemSpring.controllers;

import com.jb.CouponSystemSpring.beans.Category;
import com.jb.CouponSystemSpring.beans.Company;
import com.jb.CouponSystemSpring.beans.Coupon;
import com.jb.CouponSystemSpring.exceptions.CouponException;
import com.jb.CouponSystemSpring.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @PostMapping("/{companyId}/coupon")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCoupon(@PathVariable int companyId,
                          @RequestBody Coupon coupon) throws CouponException {
        companyService.addCoupon(companyId, coupon);
    }

    @PutMapping("/{companyId}/coupon/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCoupon(@PathVariable int companyId,
                             @PathVariable int id,
                             @RequestBody Coupon coupon) throws CouponException {
        companyService.updateCoupon(companyId, id, coupon);
    }


    @GetMapping("/{companyId}")
    public Company getDetails(@PathVariable int companyId) throws CouponException {
        return companyService.getDetails(companyId);
    }

    @DeleteMapping("/{companyId}/coupon/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCoupon(@PathVariable int companyId,
                             @PathVariable int id) throws CouponException {
        companyService.deleteCoupon(companyId, id);
    }

    @GetMapping("/{companyId}/coupon")
    public List<Coupon> getAllCoupons(@PathVariable int companyId) throws CouponException {
        return companyService.getAllCoupons(companyId);
    }

    @GetMapping("/{companyId}/coupon/category")
    public List<Coupon> getAllCoupons(@PathVariable int companyId,
                                      @RequestParam Category val) throws CouponException {
        return companyService.getAllCoupons(companyId, val);
    }

    @GetMapping("/{companyId}/coupon/price")
    public List<Coupon> getAllCoupons(@PathVariable int companyId,
                                      @RequestParam double val) throws CouponException {
        return companyService.getAllCoupons(companyId, val);
    }

}
