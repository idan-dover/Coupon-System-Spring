package com.jb.CouponSystemSpring.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "coupons")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "companyId")
    private Company company;

    private Category category;

    @Column(nullable = false, length = 40)
    private String title;

    private String description;

    @Column(nullable = false)
    private Date startDate;

    @Column(nullable = false)
    private Date endDate;

    @Column(nullable = false)
    private int amount;

    @Column(nullable = false)
    private double price;

    private String image;

    @ToString.Exclude
    @JsonIgnore
    @ManyToMany(mappedBy = "coupons")
    List<Customer> customers;

    @PreRemove
    public void removeCouponFromCustomers() {
        if (customers != null) {
            for (Customer customer : customers) {
                customer.getCoupons().remove(this);
            }
            customers.clear();
        }
    }


}
