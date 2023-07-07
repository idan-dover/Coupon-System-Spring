package com.jb.CouponSystemSpring.services;

import com.jb.CouponSystemSpring.beans.Company;
import com.jb.CouponSystemSpring.beans.Coupon;
import com.jb.CouponSystemSpring.exceptions.CouponException;

public interface CompanyService extends UserService {

    void addCoupon(int companyId, Coupon coupon) throws CouponException;

    void updateCoupon(int companyId, int couponId, Coupon coupon) throws CouponException;

    void deleteCoupon(int companyId, int couponId) throws CouponException;

    Company getDetails(int companyId) throws CouponException;
}
