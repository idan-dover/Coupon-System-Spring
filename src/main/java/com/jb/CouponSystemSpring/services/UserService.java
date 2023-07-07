package com.jb.CouponSystemSpring.services;

import com.jb.CouponSystemSpring.beans.Category;
import com.jb.CouponSystemSpring.beans.Coupon;
import com.jb.CouponSystemSpring.exceptions.CouponException;

import java.util.List;

public interface UserService {
    List<Coupon> getAllCoupons(int id) throws CouponException;

    List<Coupon> getAllCoupons(int id, Category category) throws CouponException;

    List<Coupon> getAllCoupons(int id, double maxPrice) throws CouponException;

}
