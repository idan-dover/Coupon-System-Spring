package com.jb.CouponSystemSpring.services;

import com.jb.CouponSystemSpring.Exceptions.CouponException;
import com.jb.CouponSystemSpring.beans.Category;
import com.jb.CouponSystemSpring.beans.Coupon;
import com.jb.CouponSystemSpring.beans.Customer;

import java.util.List;
import java.util.UUID;

public interface CustomerService extends UserService{

    void purchaseCoupon(UUID token, int couponId) throws CouponException;

    Customer getDetails(UUID token) throws CouponException;
}
