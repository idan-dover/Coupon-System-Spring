package com.jb.CouponSystemSpring.services;

import com.jb.CouponSystemSpring.beans.Category;
import com.jb.CouponSystemSpring.beans.Company;
import com.jb.CouponSystemSpring.beans.Coupon;
import com.jb.CouponSystemSpring.exceptions.CouponException;
import com.jb.CouponSystemSpring.exceptions.ErrMsg;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl extends ClientService implements CompanyService {

    @Override
    public void addCoupon(int companyId, Coupon coupon) throws CouponException {
        if (couponRepo.existsByCompanyIdAndTitle(companyId, coupon.getTitle())) {
            throw new CouponException(ErrMsg.DUPLICATE_TITLE);
        }

        Company company = getDetails(companyId);
        coupon.setCompany(company);
        couponRepo.save(coupon);
    }

    @Override
    public void updateCoupon(int companyId, int couponId, Coupon toUpdate) throws CouponException {
        if (!couponRepo.existsById(couponId)) {
            throw new CouponException(ErrMsg.NO_ID_FOUND);
        }

        if (couponId != toUpdate.getId()) {
            throw new CouponException(ErrMsg.ID_MISMATCH);
        }

        Company company = getDetails(companyId);

        toUpdate.setCompany(company);

        couponRepo.saveAndFlush(toUpdate);
    }

    @Override
    public void deleteCoupon(int companyId, int couponId) throws CouponException {
        if (!couponRepo.existsByIdAndCompanyId(couponId, companyId)) {
            throw new CouponException(ErrMsg.NO_OWNERSHIP);
        }
        couponRepo.deleteById(couponId);
    }

    @Override
    public List<Coupon> getAllCoupons(int companyId) {
        return couponRepo.findByCompanyId(companyId);
    }

    @Override
    public List<Coupon> getAllCoupons(int companyId, Category category) {
        return couponRepo.findByCompanyIdAndCategory(companyId, category);
    }

    @Override
    public List<Coupon> getAllCoupons(int companyId, double maxPrice) {
        return couponRepo.findByCompanyIdAndPriceLessThan(companyId, maxPrice);
    }


    @Override
    public Company getDetails(int companyId) throws CouponException {
        return companyRepo.findById(companyId)
                .orElseThrow(() -> new CouponException(ErrMsg.NO_ID_FOUND));
    }

}
