package com.jb.CouponSystemSpring.services;

import com.jb.CouponSystemSpring.Exceptions.CouponException;
import com.jb.CouponSystemSpring.beans.Customer;

public interface CustomerService extends UserService {

    void purchaseCoupon(int customerId, int couponId) throws CouponException;

    Customer getDetails(int customerId) throws CouponException;
}
