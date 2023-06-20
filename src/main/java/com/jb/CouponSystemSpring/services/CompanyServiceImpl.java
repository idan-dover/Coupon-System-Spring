package com.jb.CouponSystemSpring.services;

import com.jb.CouponSystemSpring.Exceptions.CouponException;
import com.jb.CouponSystemSpring.Exceptions.ErrMsg;
import com.jb.CouponSystemSpring.beans.Category;
import com.jb.CouponSystemSpring.beans.Company;
import com.jb.CouponSystemSpring.beans.Coupon;
import com.jb.CouponSystemSpring.models.ClientType;
import com.jb.CouponSystemSpring.security.Information;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CompanyServiceImpl extends ClientService implements CompanyService {

    @Override
    public void addCoupon(UUID token, Coupon coupon) throws CouponException {
        if (couponRepo.existsByCompanyIdAndTitle(getClientId(token, ClientType.COMPANY), coupon.getTitle())) {
            throw new CouponException(ErrMsg.DUPLICATE_TITLE);
        }

        Company company = getDetails(token);
        coupon.setCompany(company);
        couponRepo.save(coupon);
    }

    @Override
    public void updateCoupon(UUID token, int couponId, Coupon toUpdate) throws CouponException {
        if (!couponRepo.existsById(couponId)) {
            throw new CouponException(ErrMsg.NO_ID_FOUND);
        }

        if (couponId != toUpdate.getId()) {
            throw new CouponException(ErrMsg.ID_MISMATCH);
        }

        Company company = getDetails(token);

        toUpdate.setCompany(company);

        couponRepo.saveAndFlush(toUpdate);
    }

    @Override
    public void deleteCoupon(UUID token, int couponId) throws CouponException {
        if (!couponRepo.existsByIdAndCompanyId(couponId, getClientId(token, ClientType.COMPANY))) {
            throw new CouponException(ErrMsg.NO_OWNERSHIP);
        }
        couponRepo.deleteById(couponId);
    }

    @Override
    public List<Coupon> getAllCoupons(UUID token) throws CouponException {
        return couponRepo.findByCompanyId(getClientId(token, ClientType.COMPANY));
    }

    @Override
    public List<Coupon> getAllCoupons(UUID token, Category category) throws CouponException {
        return couponRepo.findByCompanyIdAndCategory(getClientId(token, ClientType.COMPANY), category);
    }

    @Override
    public List<Coupon> getAllCoupons(UUID token, double maxPrice) throws CouponException {
        return couponRepo.findByCompanyIdAndPriceLessThan(getClientId(token, ClientType.COMPANY), maxPrice);
    }


    @Override
    public Company getDetails(UUID token) throws CouponException {
        checkIfClientAllowed(token, ClientType.COMPANY);

        Information info = tokenService.getUserInfo(token, ClientType.COMPANY);
        return companyRepo.findById(info.getId())
                .orElseThrow(() -> new CouponException(ErrMsg.NO_ID_FOUND));
    }

}
