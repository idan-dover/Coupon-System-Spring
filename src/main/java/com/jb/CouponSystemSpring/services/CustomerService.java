package com.jb.CouponSystemSpring.services;

import com.jb.CouponSystemSpring.beans.Category;

public interface CustomerService {

    void purchaseCoupon(int couponId);

    void getAllCoupons();

    void getAllCoupons(Category category);

    void getAllCoupons(double maxPrice);

    void getDetails();


}
