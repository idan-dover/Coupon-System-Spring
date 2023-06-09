package com.jb.CouponSystemSpring.services;

import com.jb.CouponSystemSpring.Exceptions.CouponException;
import com.jb.CouponSystemSpring.Exceptions.ErrMsg;
import com.jb.CouponSystemSpring.beans.Category;
import com.jb.CouponSystemSpring.beans.ClientType;
import com.jb.CouponSystemSpring.beans.Company;
import com.jb.CouponSystemSpring.beans.Coupon;
import com.jb.CouponSystemSpring.security.Information;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CompanyServiceImpl extends ClientService implements CompanyService {

    @Override
    public void addCoupon(UUID token, Coupon coupon) throws CouponException {
        Company company = getDetails(token);

        if (couponRepo.existsByCompanyIdAndTitle(company.getId(), coupon.getTitle())) {
            throw new CouponException(ErrMsg.DUPLICATE_TITLE);
        }

        coupon.setCompany(company);
        couponRepo.save(coupon);
    }

    @Override
    public void updateCoupon(UUID token, int couponId, Coupon toUpdate) throws CouponException {
        Company company = getDetails(token);
        Coupon current = couponRepo.findById(couponId)
                .orElseThrow(() -> new CouponException(ErrMsg.NO_ID_FOUND));

        if (current.getId() != toUpdate.getId()) {
            throw new CouponException(ErrMsg.ID_MISMATCH);
        }

        toUpdate.setCompany(company);

        couponRepo.saveAndFlush(toUpdate);
    }

    @Override
    public void deleteCoupon(UUID token, int couponId) throws CouponException {
        couponRepo.deleteById(couponId);
    }

    @Override
    public List<Coupon> getAllCoupons(UUID token) throws CouponException {
        Company company = getDetails(token);
        return company.getCoupons();
    }

    @Override
    public List<Coupon> getAllCoupons(UUID token, Category category) throws CouponException {
        Company company = getDetails(token);
        return company.getCoupons()
                .stream()
                .filter(coupon -> coupon.getCategory().equals(category)).toList();
    }

    @Override
    public List<Coupon> getAllCoupons(UUID token, double maxPrice) throws CouponException {
        Company company = getDetails(token);
        return company.getCoupons()
                .stream()
                .filter(coupon -> coupon.getPrice() < maxPrice).toList();
    }

    @Override
    public Company getDetails(UUID token) throws CouponException {
        if (!tokenService.isUserAllowed(token, ClientType.COMPANY)) {
            throw new CouponException(ErrMsg.INCORRECT_TOKEN);
        }

        Information info = tokenService.getUserInfo(token, ClientType.COMPANY);
        return companyRepo.findById(info.getId())
                .orElseThrow(() -> new CouponException(ErrMsg.NO_ID_FOUND));
    }
}
