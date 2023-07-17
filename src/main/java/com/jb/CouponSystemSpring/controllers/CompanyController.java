package com.jb.CouponSystemSpring.controllers;

import com.jb.CouponSystemSpring.beans.Category;
import com.jb.CouponSystemSpring.beans.Company;
import com.jb.CouponSystemSpring.beans.Coupon;
import com.jb.CouponSystemSpring.exceptions.CouponException;
import com.jb.CouponSystemSpring.services.CompanyService;
import jakarta.servlet.http.HttpServletRequest;
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

    @Autowired
    private HttpServletRequest request;

    @PostMapping("/coupon")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCoupon(@RequestBody Coupon coupon) throws CouponException {
        int companyId = (int) request.getAttribute("companyId");
        companyService.addCoupon(companyId, coupon);
    }

    @PutMapping("/coupon/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCoupon(@PathVariable int id,
                             @RequestBody Coupon coupon) throws CouponException {
        int companyId = (int) request.getAttribute("companyId");
        companyService.updateCoupon(companyId, id, coupon);
    }


    @GetMapping
    public Company getDetails() throws CouponException {
        int companyId = (int) request.getAttribute("companyId");
        return companyService.getDetails(companyId);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCoupon(@RequestParam int val) throws CouponException {
        int companyId = (int) request.getAttribute("companyId");
        companyService.deleteCoupon(companyId, val);
    }

    @GetMapping("/coupon")
    public List<Coupon> getAllCoupons(@RequestHeader("Authorization") UUID token) throws CouponException {
        int companyId = (int) request.getAttribute("companyId");
        return companyService.getAllCoupons(companyId);
    }

    @GetMapping("/coupon/category")
    public List<Coupon> getAllCoupons(@RequestParam Category val) throws CouponException {
        int companyId = (int) request.getAttribute("companyId");
        return companyService.getAllCoupons(companyId, val);
    }

    @GetMapping("/coupon/price")
    public List<Coupon> getAllCoupons(@RequestParam double val) throws CouponException {
        int companyId = (int) request.getAttribute("companyId");
        return companyService.getAllCoupons(companyId, val);
    }


}
