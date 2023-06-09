package com.jb.CouponSystemSpring.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "customers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 30)
    private String firstName;

    @Column(length = 30)
    private String lastName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @ToString.Exclude
    @JsonIgnore
    @ManyToMany
    private List<Coupon> coupons;

    public void addCoupon(Coupon coupon) {
        coupons.add(coupon);
        coupon.customers.add(this);
    }


}
