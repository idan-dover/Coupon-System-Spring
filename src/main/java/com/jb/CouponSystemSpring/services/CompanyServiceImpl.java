package com.jb.CouponSystemSpring.services;

import com.jb.CouponSystemSpring.beans.Category;
import com.jb.CouponSystemSpring.beans.Company;
import com.jb.CouponSystemSpring.beans.Coupon;

import java.util.List;

public class CompanyServiceImpl extends ClientService implements CompanyService{

    @Override
    public void addCoupon(Coupon coupon) {

    }

    @Override
    public void updateCoupon(int couponId, Coupon coupon) {

    }

    @Override
    public void deleteCoupon(int couponId) {

    }

    @Override
    public List<Coupon> getAllCoupons() {
        return null;
    }

    @Override
    public List<Coupon> getAllCoupons(Category category) {
        return null;
    }

    @Override
    public List<Coupon> getAllCoupons(double maxPrice) {
        return null;
    }

    @Override
    public Company getCompanyDetails() {
        return null;
    }
}
