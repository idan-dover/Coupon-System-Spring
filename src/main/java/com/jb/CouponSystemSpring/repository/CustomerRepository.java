package com.jb.CouponSystemSpring.repository;

import com.jb.CouponSystemSpring.beans.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    boolean existsByEmail(String email);

    Optional<Customer> findByEmail(String email);

    boolean existsByEmailAndPassword(String email, String password);

    @Query(value = "SELECT `id` FROM `coupon-system-spring`.customers WHERE `email`=?", nativeQuery = true)
    int findIdByEmail(String email);

    boolean existsByIdAndCouponsId(int customerId, int couponId);

}

