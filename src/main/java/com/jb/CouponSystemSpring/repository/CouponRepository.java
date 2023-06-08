package com.jb.CouponSystemSpring.repository;

import com.jb.CouponSystemSpring.beans.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CouponRepository extends JpaRepository<Coupon,Integer> {
    List<Coupon> findByCompanyId(int companyId);
}
