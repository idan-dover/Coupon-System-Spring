package com.jb.CouponSystemSpring.repository;

import com.jb.CouponSystemSpring.beans.Category;
import com.jb.CouponSystemSpring.beans.Coupon;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Integer> {
    List<Coupon> findByCompanyId(int companyId);

    List<Coupon> findByCompanyIdAndCategory(int companyId, Category category);

    List<Coupon> findByCompanyIdAndPriceLessThan(int companyId, double price);

    boolean existsById(int couponId);

    boolean existsByCompanyIdAndTitle(int companyId, String title);

    boolean existsByIdAndEndDateBefore(int couponId, LocalDate today);

    boolean existsByIdAndAmountLessThan(int couponId, int amount);


    @Modifying
    @Transactional
    @Query(value = "UPDATE `coupon-system-spring`.coupons c SET c.amount = c.amount - 1 WHERE c.id = ?", nativeQuery = true)
    void reduceAmountById(int couponId);


    @Modifying
    @Transactional
    @Query(value = "delete from customers_coupons where customers_coupons.coupons_id " +
            "in(select c1_0.id from coupons c1_0 where c1_0.end_date<?)", nativeQuery = true)
    void removeCustomersFromExpiredCoupons(Date expiryDate);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM coupons c WHERE c.end_date < ?", nativeQuery = true)
    void deleteExpiredCoupons(Date expiryDate);

    default void removeExpiredCoupons(Date expiryDate) {
        removeCustomersFromExpiredCoupons(expiryDate);
        deleteExpiredCoupons(expiryDate);
    }

    boolean existsByIdAndCompanyId(int couponId, int companyId);
}
