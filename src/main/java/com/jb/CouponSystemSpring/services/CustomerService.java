package com.jb.CouponSystemSpring.services;

import com.jb.CouponSystemSpring.beans.Customer;
import com.jb.CouponSystemSpring.exceptions.CouponException;

public interface CustomerService extends UserService {

    void purchaseCoupon(int customerId, int couponId) throws CouponException;

    Customer getDetails(int customerId) throws CouponException;
}
