package com.jb.CouponSystemSpring.repository;

import com.jb.CouponSystemSpring.beans.Coupon;
import com.jb.CouponSystemSpring.beans.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    boolean existsByEmail(String email);

    boolean existsByEmailAndPassword(String email, String password);

    boolean existsByIdAndCouponsId(int customerId, int couponId);

    @Query(value = "SELECT `id` FROM `coupon-system-spring`.customers WHERE `email`=?", nativeQuery = true)
    int findIdByEmail(String email);

    @Query("SELECT c FROM Coupon c " +
            "WHERE NOT EXISTS " +
            "(SELECT cc FROM c.customers cc WHERE cc.id = :customerId)")
    List<Coupon> findUnsoldCoupons(@Param("customerId") int customerId);
    
}

