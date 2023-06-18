package com.jb.CouponSystemSpring.services;

import com.jb.CouponSystemSpring.Exceptions.CouponException;
import com.jb.CouponSystemSpring.beans.Category;
import com.jb.CouponSystemSpring.beans.Coupon;

import java.util.List;
import java.util.UUID;

public interface UserService {
    List<Coupon> getAllCoupons(UUID token) throws CouponException;

    List<Coupon> getAllCoupons(UUID token, Category category) throws CouponException;

    List<Coupon> getAllCoupons(UUID token, double maxPrice) throws CouponException;

}
