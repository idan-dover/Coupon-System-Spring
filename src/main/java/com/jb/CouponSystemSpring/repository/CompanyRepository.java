package com.jb.CouponSystemSpring.repository;

import com.jb.CouponSystemSpring.beans.Company;
import com.jb.CouponSystemSpring.beans.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Integer> {

    boolean existsByName(String name);
    boolean existsByEmail(String email);


    Optional<Company> findByEmail(String email);


    boolean existsByEmailAndPassword(String email, String password);

    @Query(value = "SELECT `id` FROM `coupon-system-spring`.companies WHERE `email`=?;", nativeQuery = true)
    int findIdByEmail(String email);
}
