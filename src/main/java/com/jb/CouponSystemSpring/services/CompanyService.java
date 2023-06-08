package com.jb.CouponSystemSpring.services;

import com.jb.CouponSystemSpring.beans.Category;
import com.jb.CouponSystemSpring.beans.Company;
import com.jb.CouponSystemSpring.beans.Coupon;

import java.util.List;

public interface CompanyService {

    void addCoupon(Coupon coupon);

    void updateCoupon(int couponId, Coupon coupon);

    void deleteCoupon(int couponId);

    List<Coupon> getAllCoupons();

    List<Coupon> getAllCoupons(Category category);

    List<Coupon> getAllCoupons(double maxPrice);

    Company getCompanyDetails();
}
