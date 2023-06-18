package com.jb.CouponSystemSpring.beans;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "companies")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 30)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @ToString.Exclude
    @OneToMany(mappedBy = "company", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Coupon> coupons;

    public void addCoupons(List<Coupon> coupons) {
        setCoupons(coupons);
        coupons.forEach(coupon -> coupon.setCompany(this));
    }
}
