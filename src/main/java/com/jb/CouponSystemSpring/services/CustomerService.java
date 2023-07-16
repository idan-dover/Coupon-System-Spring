package com.jb.CouponSystemSpring.services;

import com.jb.CouponSystemSpring.beans.Coupon;
import com.jb.CouponSystemSpring.beans.Customer;
import com.jb.CouponSystemSpring.exceptions.CouponException;

import java.util.List;

public interface CustomerService extends UserService {

    void purchaseCoupon(int customerId, int couponId) throws CouponException;

    List<Coupon> getUnsoldCoupons(int customerId) throws CouponException;
    
    Customer getDetails(int customerId) throws CouponException;

}
