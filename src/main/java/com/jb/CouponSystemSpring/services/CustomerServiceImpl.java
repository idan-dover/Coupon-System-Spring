package com.jb.CouponSystemSpring.services;

import com.jb.CouponSystemSpring.beans.Category;
import com.jb.CouponSystemSpring.beans.Coupon;
import com.jb.CouponSystemSpring.beans.Customer;
import com.jb.CouponSystemSpring.exceptions.CouponException;
import com.jb.CouponSystemSpring.exceptions.ErrMsg;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CustomerServiceImpl extends ClientService implements CustomerService {


    @Override
    public void purchaseCoupon(int customerId, int couponId) throws CouponException {
        if (customerRepo.existsByIdAndCouponsId(customerId, couponId)) {
            throw new CouponException(ErrMsg.CANT_PURCHASE_TWICE);
        }

        if (couponRepo.existsByIdAndAmountLessThan(couponId, 1)) {
            throw new CouponException(ErrMsg.OUT_OF_STOCK);
        }

        if (couponRepo.existsByIdAndEndDateBefore(couponId, LocalDate.now())) {
            throw new CouponException(ErrMsg.EXPIRED);
        }

        couponRepo.reduceAmountByOne(couponId);

        Customer customer = getDetails(customerId);

        Coupon coupon = couponRepo.findById(couponId)
                .orElseThrow(() -> new CouponException(ErrMsg.NO_ID_FOUND));

        customer.addCoupon(coupon);

        customerRepo.saveAndFlush(customer);
    }

    @Override
    public List<Coupon> getAllCoupons(int customerId) throws CouponException {
        return getDetails(customerId).getCoupons();
    }

    @Override
    public List<Coupon> getAllCoupons(int customerId, Category category) throws CouponException {
        return getDetails(customerId).getCoupons()
                .stream()
                .filter(coupon -> coupon.getCategory().equals(category)).toList();

    }

    @Override
    public List<Coupon> getAllCoupons(int customerId, double maxPrice) throws CouponException {
        return getDetails(customerId).getCoupons()
                .stream()
                .filter(coupon -> coupon.getPrice() < maxPrice).toList();
    }

    @Override
    public Customer getDetails(int customerId) throws CouponException {

        return customerRepo.findById(customerId)
                .orElseThrow(() -> new CouponException(ErrMsg.NO_ID_FOUND));
    }


}
