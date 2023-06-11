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

        Company company1 = Company.builder()
                .name("Nike")
                .email("info@nike.com")
                .password("1234")
                .coupons(null)
                .build();

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

        Company company2 = Company.builder()
                .name("Apple")
                .email("info@apple.com")
                .password("1234")
                .coupons(null)
                .build();

        Coupon coupon2 = Coupon.builder()
                .company(null)
                .category(Category.ELECTRONICS)
                .title("iPhone Discount")
                .description("Get 20% off on all iPhone models")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusMonths(1)))
                .amount(50)
                .price(0)
                .image("https://example.com/iphone-discount.jpg")
                .build();

        Company company3 = Company.builder()
                .name("Starbucks")
                .email("info@starbucks.com")
                .password("1234")
                .coupons(null)
                .build();

        Coupon coupon3 = Coupon.builder()
                .company(null)
                .category(Category.FOOD)
                .title("Coffee Loyalty Card")
                .description("Buy 9 coffees and get the 10th coffee for free")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusYears(1)))
                .amount(1000)
                .price(0)
                .image("https://example.com/starbucks-loyalty.jpg")
                .build();

        Company company4 = Company.builder()
                .name("Amazon")
                .email("info@amazon.com")
                .password("1234")
                .coupons(null)
                .build();

        Coupon coupon4 = Coupon.builder()
                .company(null)
                .category(Category.ELECTRONICS)
                .title("Prime Day Deals")
                .description("Exclusive discounts on electronics for Amazon Prime members")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusDays(2)))
                .amount(500)
                .price(0)
                .image("https://example.com/amazon-prime-deals.jpg")
                .build();

        Company company5 = Company.builder()
                .name("Fitness First")
                .email("info@fitnessfirst.com")
                .password("1234")
                .coupons(null)
                .build();

        Coupon coupon5 = Coupon.builder()
                .company(null)
                .category(Category.SPORT)
                .title("Gym Membership Discount")
                .description("Get 30% off on a 12-month gym membership")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusMonths(3)))
                .amount(100)
                .price(299.99)
                .image("https://example.com/gym-membership.jpg")
                .build();


        Customer customer1 = Customer.builder()
                .firstName("Moshe")
                .lastName("Moshe")
                .email("moshe@gmail.com")
                .password("1234")
                .build();

        Customer customer2 = Customer.builder()
                .firstName("Sarah")
                .lastName("Johnson")
                .email("sarah@gmail.com")
                .password("1234")
                .build();

        Customer customer3 = Customer.builder()
                .firstName("John")
                .lastName("Doe")
                .email("john@gmail.com")
                .password("1234")
                .build();

        Customer customer4 = Customer.builder()
                .firstName("Emily")
                .lastName("Smith")
                .email("emily@gmail.com")
                .password("1234")
                .build();

        Customer customer5 = Customer.builder()
                .firstName("Michael")
                .lastName("Williams")
                .email("michael@gmail.com")
                .password("1234")
                .build();

        Customer customer6 = Customer.builder()
                .firstName("Jessica")
                .lastName("Brown")
                .email("jessica@gmail.com")
                .password("1234")
                .build();

        Customer customer7 = Customer.builder()
                .firstName("David")
                .lastName("Miller")
                .email("david@gmail.com")
                .password("1234")
                .build();

        Customer customer8 = Customer.builder()
                .firstName("Olivia")
                .lastName("Jones")
                .email("olivia@gmail.com")
                .password("1234")
                .build();

        Customer customer9 = Customer.builder()
                .firstName("Daniel")
                .lastName("Taylor")
                .email("daniel@gmail.com")
                .password("1234")
                .build();

        Customer customer10 = Customer.builder()
                .firstName("Sophia")
                .lastName("Anderson")
                .email("sophia@gmail.com")
                .password("1234")
                .build();




        companyRepo.saveAll(List.of(company1, company2, company3, company4, company5));
        customerRepo.saveAll(List.of(customer1, customer2, customer3, customer4, customer5, customer6, customer7, customer8, customer9, customer10));
    }
}
