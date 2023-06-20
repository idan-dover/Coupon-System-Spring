package com.jb.CouponSystemSpring.services;

import com.jb.CouponSystemSpring.Exceptions.CouponException;
import com.jb.CouponSystemSpring.Exceptions.ErrMsg;
import com.jb.CouponSystemSpring.beans.Category;
import com.jb.CouponSystemSpring.beans.ClientType;
import com.jb.CouponSystemSpring.beans.Coupon;
import com.jb.CouponSystemSpring.beans.Customer;
import com.jb.CouponSystemSpring.security.Information;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class CustomerServiceImpl extends ClientService implements CustomerService {
    @Override
    public void purchaseCoupon(UUID token, int couponId) throws CouponException {
        if (customerRepo.existsByIdAndCouponsId(getClientId(token, ClientType.CUSTOMER), couponId)) {
            throw new CouponException(ErrMsg.CANT_PURCHASE_TWICE);
        }

        if (couponRepo.existsByIdAndAmountLessThan(couponId, 1)) {
            throw new CouponException(ErrMsg.OUT_OF_STOCK);
        }

        if (couponRepo.existsByIdAndEndDateBefore(couponId, LocalDate.now())) {
            throw new CouponException(ErrMsg.EXPIRED);
        }

        couponRepo.reduceAmountById(couponId);

        Customer customer = getDetails(token);

        Coupon coupon = couponRepo.findById(couponId).get();

        customer.addCoupon(coupon);

        customerRepo.saveAndFlush(customer);
    }

    @Override
    public List<Coupon> getAllCoupons(UUID token) throws CouponException {
        return getDetails(token).getCoupons();
    }

    @Override
    public List<Coupon> getAllCoupons(UUID token, Category category) throws CouponException {
        return getDetails(token).getCoupons()
                .stream()
                .filter(coupon -> coupon.getCategory().equals(category)).toList();

    }

    @Override
    public List<Coupon> getAllCoupons(UUID token, double maxPrice) throws CouponException {
        return getDetails(token).getCoupons()
                .stream()
                .filter(coupon -> coupon.getPrice() < maxPrice).toList();
    }

    @Override
    public Customer getDetails(UUID token) throws CouponException {
        checkIfClientAllowed(token, ClientType.CUSTOMER);

        Information info = tokenService.getUserInfo(token, ClientType.CUSTOMER);
        return customerRepo.findById(info.getId())
                .orElseThrow(() -> new CouponException(ErrMsg.NO_ID_FOUND));
    }


}
