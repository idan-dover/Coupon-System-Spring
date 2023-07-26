package com.jb.CouponSystemSpring.repository;

import com.jb.CouponSystemSpring.beans.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {

    boolean existsByName(String name);

    boolean existsByEmail(String email);

    boolean existsByEmailAndPassword(String email, String password);

    @Query(value = "SELECT `id` FROM companies WHERE `email`=?;", nativeQuery = true)
    int findIdByEmail(String email);
}
