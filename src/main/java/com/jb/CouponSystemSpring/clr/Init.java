package com.jb.CouponSystemSpring.clr;

import com.jb.CouponSystemSpring.beans.Category;
import com.jb.CouponSystemSpring.beans.Company;
import com.jb.CouponSystemSpring.beans.Coupon;
import com.jb.CouponSystemSpring.beans.Customer;
import com.jb.CouponSystemSpring.repository.CompanyRepository;
import com.jb.CouponSystemSpring.repository.CouponRepository;
import com.jb.CouponSystemSpring.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Component
@Order(1)
public class Init implements CommandLineRunner {

    @Autowired
    CompanyRepository companyRepo;

    @Autowired
    CustomerRepository customerRepo;

    @Autowired
    CouponRepository couponRepo;

    @Override
    public void run(String... args) throws Exception {
        Coupon coupon1 = Coupon.builder()
                .company(null)
                .category(Category.SPORT)
                .title("free shoes")
                .description("air shoes for free only for two weeks from today")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusWeeks(2)))
                .amount(100)
                .price(199.99)
                .image("https://media2.giphy.com/media/frZfEju9PJQ8DAAEX6/giphy.gif?cid=ecf05e47b678tlyak0z23rubnjaty6oc72wx0tsiqdup1ewr&ep=v1_gifs_search&rid=giphy.gif&ct=g")
                .build();

        Company company1 = Company.builder()
                .name("Nike")
                .email("info@nike.com")
                .password("1234")
                .coupons(List.of(coupon1))
                .build();

        Customer customer1 = Customer.builder()
                .firstName("Moshe")
                .lastName("David")
                .email("moshe@gmail.com")
                .password("1234")
                .build();

        coupon1.setCompany(company1);
        coupon1.setCustomers(List.of(customer1));


        customerRepo.save(customer1);
        companyRepo.save(company1);
        couponRepo.save(coupon1);
    }
}
