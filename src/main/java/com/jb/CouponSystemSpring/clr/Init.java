//package com.jb.CouponSystemSpring.clr;
//
//import com.jb.CouponSystemSpring.beans.Category;
//import com.jb.CouponSystemSpring.beans.Company;
//import com.jb.CouponSystemSpring.beans.Coupon;
//import com.jb.CouponSystemSpring.beans.Customer;
//import com.jb.CouponSystemSpring.repository.CompanyRepository;
//import com.jb.CouponSystemSpring.repository.CouponRepository;
//import com.jb.CouponSystemSpring.repository.CustomerRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//
//import java.sql.Date;
//import java.time.LocalDate;
//import java.util.List;
//
//@Component
//@Order(1)
//public class Init implements CommandLineRunner {
//
//    @Autowired
//    CompanyRepository companyRepo;
//
//    @Autowired
//    CustomerRepository customerRepo;
//
//    @Autowired
//    CouponRepository couponRepo;
//
//    @Override
//    public void run(String... args) throws Exception {
//
//        Company company1 = Company.builder()
//                .name("Starbucks")
//                .email("info@starbucks.com")
//                .password("1234")
//                .coupons(null)
//                .build();
//
//        Coupon coupon1_1 = Coupon.builder()
//                .company(null)
//                .category(Category.FOOD)
//                .title("Coffee Loyalty Card")
//                .description("Buy 9 coffees and get the 10th coffee for free")
//                .startDate(Date.valueOf(LocalDate.now()))
//                .endDate(Date.valueOf(LocalDate.now().plusYears(1)))
//                .amount(1000)
//                .price(0)
//                .image("https://media.giphy.com/media/hPTZgtzfRIB5Nfb5rL/giphy.gif")
//                .build();
//
//        Coupon coupon1_2 = Coupon.builder()
//                .company(null)
//                .category(Category.FOOD)
//                .title("Discounted Coffee Bundle")
//                .description("Buy 5 coffees for the price of 4")
//                .startDate(Date.valueOf(LocalDate.now()))
//                .endDate(Date.valueOf(LocalDate.now().plusMonths(6)))
//                .amount(500)
//                .price(300)
//                .image("https://media.giphy.com/media/X8OQGmNtNXTyg/giphy.gif")
//                .build();
//
//        Coupon coupon1_3 = Coupon.builder()
//                .company(null)
//                .category(Category.FOOD)
//                .title("Free Pastry with Coffee Purchase")
//                .description("Buy any coffee and get a pastry for free")
//                .startDate(Date.valueOf(LocalDate.now()))
//                .endDate(Date.valueOf(LocalDate.now().plusWeeks(2)))
//                .amount(200)
//                .price(0)
//                .image("https://media.giphy.com/media/Y0aEU8eb8HCUAfRCRu/giphy.gif")
//                .build();
//
//        Company company2 = Company.builder()
//                .name("Super-Pharm")
//                .email("info@superpharm.com")
//                .password("1234")
//                .coupons(null)
//                .build();
//
//        Coupon coupon2_1 = Coupon.builder()
//                .company(null)
//                .category(Category.HEALTH)
//                .title("Gym Membership Discount")
//                .description("Get 30% off on a 12-month gym membership")
//                .startDate(Date.valueOf(LocalDate.now()))
//                .endDate(Date.valueOf(LocalDate.now().plusMonths(3)))
//                .amount(100)
//                .price(299.99)
//                .image("https://media.giphy.com/media/WqmYGa2LjQlTG/giphy.gif")
//                .build();
//
//        Coupon coupon2_2 = Coupon.builder()
//                .company(null)
//                .category(Category.HEALTH)
//                .title("Fitness Equipment Sale")
//                .description("Save 20% on all fitness equipment")
//                .startDate(Date.valueOf(LocalDate.now()))
//                .endDate(Date.valueOf(LocalDate.now().plusWeeks(2)))
//                .amount(50)
//                .price(25.9)
//                .image("https://media.giphy.com/media/u00wTXSNz2jtuxlzkw/giphy.gif")
//                .build();
//
//        Coupon coupon2_3 = Coupon.builder()
//                .company(null)
//                .category(Category.HEALTH)
//                .title("Vitamin Bundle Offer")
//                .description("Buy 2 vitamins, get 1 free")
//                .startDate(Date.valueOf(LocalDate.now()))
//                .endDate(Date.valueOf(LocalDate.now().plusMonths(1)))
//                .amount(200)
//                .price(30.5)
//                .image("https://media.giphy.com/media/fV2sJE2roK6DJz8f4F/giphy.gif")
//                .build();
//
//        Company company3 = Company.builder()
//                .name("Nike")
//                .email("info@nike.com")
//                .password("1234")
//                .coupons(null)
//                .build();
//
//        Coupon coupon3_1 = Coupon.builder()
//                .company(null)
//                .category(Category.SPORT)
//                .title("free shoes")
//                .description("air shoes for free only for two weeks from today")
//                .startDate(Date.valueOf(LocalDate.now()))
//                .endDate(Date.valueOf(LocalDate.now().plusWeeks(2)))
//                .amount(100)
//                .price(199.99)
//                .image("https://media.giphy.com/media/F6ZC06fX688qk/giphy.gif")
//                .build();
//
//        Coupon coupon3_2 = Coupon.builder()
//                .company(null)
//                .category(Category.SPORT)
//                .title("20% Off on Running Gear")
//                .description("Get 20% off on all running gear items")
//                .startDate(Date.valueOf(LocalDate.now()))
//                .endDate(Date.valueOf(LocalDate.now().plusMonths(1)))
//                .amount(50)
//                .price(333.33)
//                .image("https://media.giphy.com/media/2URjZ4LpKF0jrFWjd4/giphy.gif")
//                .build();
//
//        Coupon coupon3_3 = Coupon.builder()
//                .company(null)
//                .category(Category.SPORT)
//                .title("Athletic Apparel Sale")
//                .description("Buy 1 get 1 free on all athletic apparel")
//                .startDate(Date.valueOf(LocalDate.now()))
//                .endDate(Date.valueOf(LocalDate.now().plusWeeks(3)))
//                .amount(200)
//                .price(237.50)
//                .image("https://media.giphy.com/media/iFGhsoee2xTOM/giphy.gif")
//                .build();
//
//        Company company4 = Company.builder()
//                .name("Apple")
//                .email("info@apple.com")
//                .password("1234")
//                .coupons(null)
//                .build();
//
//        Coupon coupon4_1 = Coupon.builder()
//                .company(null)
//                .category(Category.ELECTRONICS)
//                .title("iPhone Discount")
//                .description("Get 20% off on all iPhone models")
//                .startDate(Date.valueOf(LocalDate.now()))
//                .endDate(Date.valueOf(LocalDate.now().plusMonths(1)))
//                .amount(50)
//                .price(10)
//                .image("https://media.giphy.com/media/26n79t82lmj989iAE/giphy.gif")
//                .build();
//
//        Coupon coupon4_2 = Coupon.builder()
//                .company(null)
//                .category(Category.ELECTRONICS)
//                .title("MacBook Pro Sale")
//                .description("Save $200 on all MacBook Pro models")
//                .startDate(Date.valueOf(LocalDate.now()))
//                .endDate(Date.valueOf(LocalDate.now().plusWeeks(2)))
//                .amount(30)
//                .price(750)
//                .image("https://media.giphy.com/media/igGAkVwYTpLbmJTcHf/giphy.gif")
//                .build();
//
//        Coupon coupon4_3 = Coupon.builder()
//                .company(null)
//                .category(Category.ELECTRONICS)
//                .title("Apple Watch Bundle Offer")
//                .description("Buy an Apple Watch and get a free accessory")
//                .startDate(Date.valueOf(LocalDate.now()))
//                .endDate(Date.valueOf(LocalDate.now().plusMonths(1)))
//                .amount(100)
//                .price(1000)
//                .image("https://media.giphy.com/media/5xtDarqPCe4BofVSz3W/giphy.gif")
//                .build();
//
//        Company company5 = Company.builder()
//                .name("AirBNB")
//                .email("info@airbnb.com")
//                .password("1234")
//                .coupons(null)
//                .build();
//
//        Coupon coupon5_1 = Coupon.builder()
//                .company(null)
//                .category(Category.VACATION)
//                .title("Houses in paris")
//                .description("Now offering many different houses in 30% discount")
//                .startDate(Date.valueOf(LocalDate.now()))
//                .endDate(Date.valueOf(LocalDate.now().plusMonths(2)))
//                .amount(50)
//                .price(75)
//                .image("https://media.giphy.com/media/vQBkSwVkEZfTq/giphy.gif")
//                .build();
//
//        Coupon coupon5_2 = Coupon.builder()
//                .company(null)
//                .category(Category.VACATION)
//                .title("Beach Getaway Sale")
//                .description("Book a beach vacation and get $100 off")
//                .startDate(Date.valueOf(LocalDate.now()))
//                .endDate(Date.valueOf(LocalDate.now().plusWeeks(4)))
//                .amount(30)
//                .price(60)
//                .image("https://media.giphy.com/media/mCJkHm7o6vSoAKcLY7/giphy.gif")
//                .build();
//
//        Coupon coupon5_3 = Coupon.builder()
//                .company(null)
//                .category(Category.VACATION)
//                .title("Cabin Retreat Discount")
//                .description("Enjoy 20% off on cabin rentals")
//                .startDate(Date.valueOf(LocalDate.now()))
//                .endDate(Date.valueOf(LocalDate.now().plusMonths(1)))
//                .amount(100)
//                .price(35)
//                .image("https://media.giphy.com/media/3o6Ztrs0GnTt4GkFO0/giphy.gif")
//                .build();
//
//        Company company6 = Company.builder()
//                .name("Ikea")
//                .email("info@ikea.com")
//                .password("1234")
//                .coupons(null)
//                .build();
//
//        Coupon coupon6_1 = Coupon.builder()
//                .company(null)
//                .category(Category.FURNITURE)
//                .title("Discount on beds")
//                .description("All beds receive 15% discount")
//                .startDate(Date.valueOf(LocalDate.now()))
//                .endDate(Date.valueOf(LocalDate.now().plusMonths(3)))
//                .amount(70)
//                .price(150)
//                .image("https://media.giphy.com/media/HwF2mDkVbA0NO/giphy.gif")
//                .build();
//
//        Coupon coupon6_2 = Coupon.builder()
//                .company(null)
//                .category(Category.FURNITURE)
//                .title("Sofa Sale")
//                .description("Save $200 on all sofa sets")
//                .startDate(Date.valueOf(LocalDate.now()))
//                .endDate(Date.valueOf(LocalDate.now().plusWeeks(2)))
//                .amount(50)
//                .price(0)
//                .image("https://media.giphy.com/media/kgDnpyY40oYYOPaiYp/giphy.gif")
//                .build();
//
//        Coupon coupon6_3 = Coupon.builder()
//                .company(null)
//                .category(Category.FURNITURE)
//                .title("Dining Table Bundle Offer")
//                .description("Buy a dining table and get 4 chairs for free")
//                .startDate(Date.valueOf(LocalDate.now()))
//                .endDate(Date.valueOf(LocalDate.now().plusMonths(1)))
//                .amount(100)
//                .price(0)
//                .image("https://media.giphy.com/media/3o6Mbte1bl9Pb7wmys/giphy.gif")
//                .build();
//
//        Company company7 = Company.builder()
//                .name("Nissan")
//                .email("info@nissan.com")
//                .password("1234")
//                .coupons(null)
//                .build();
//
//        Coupon coupon7_1 = Coupon.builder()
//                .company(null)
//                .category(Category.CARS)
//                .title("Tires here")
//                .description("You may switch your tires for free with this coupon")
//                .startDate(Date.valueOf(LocalDate.now()))
//                .endDate(Date.valueOf(LocalDate.now().plusWeeks(5)))
//                .amount(1000)
//                .price(250)
//                .image("https://media.giphy.com/media/TPqd1b3bE0oTbLbMmb/giphy.gif")
//                .build();
//
//        Coupon coupon7_2 = Coupon.builder()
//                .company(null)
//                .category(Category.CARS)
//                .title("Summer Car Maintenance")
//                .description("Get a 20% discount on summer car maintenance services")
//                .startDate(Date.valueOf(LocalDate.now()))
//                .endDate(Date.valueOf(LocalDate.now().plusMonths(2)))
//                .amount(500)
//                .price(0)
//                .image("https://media.giphy.com/media/IelxugxenjdyU/giphy.gif")
//                .build();
//
//        Coupon coupon7_3 = Coupon.builder()
//                .company(null)
//                .category(Category.CARS)
//                .title("New Car Discount")
//                .description("Receive $1000 off on your purchase of a new Nissan car")
//                .startDate(Date.valueOf(LocalDate.now()))
//                .endDate(Date.valueOf(LocalDate.now().plusMonths(3)))
//                .amount(200)
//                .price(0)
//                .image("https://media.giphy.com/media/10cXff6xep02Na/giphy.gif")
//                .build();
//
//        Company company8 = Company.builder()
//                .name("American Eagle")
//                .email("info@americaneagle.com")
//                .password("1234")
//                .coupons(null)
//                .build();
//
//        Coupon coupon8_1 = Coupon.builder()
//                .company(null)
//                .category(Category.CLOTHING)
//                .title("Jeans sales")
//                .description("end of season sales, all jeans are 70% off")
//                .startDate(Date.valueOf(LocalDate.now()))
//                .endDate(Date.valueOf(LocalDate.now().plusWeeks(3)))
//                .amount(1000)
//                .price(250)
//                .image("https://media.giphy.com/media/uSpdhRgqsCc0/giphy.gif")
//                .build();
//
//        Coupon coupon8_2 = Coupon.builder()
//                .company(null)
//                .category(Category.CLOTHING)
//                .title("Summer Collection")
//                .description("Get 20% off on all summer clothing items")
//                .startDate(Date.valueOf(LocalDate.now()))
//                .endDate(Date.valueOf(LocalDate.now().plusMonths(2)))
//                .amount(500)
//                .price(0)
//                .image("https://media.giphy.com/media/l1TJVLJM0hfnGJjE4t/giphy.gif")
//                .build();
//
//        Coupon coupon8_3 = Coupon.builder()
//                .company(null)
//                .category(Category.CLOTHING)
//                .title("Buy One Get One Free")
//                .description("Buy any shirt and get another one for free")
//                .startDate(Date.valueOf(LocalDate.now()))
//                .endDate(Date.valueOf(LocalDate.now().plusWeeks(4)))
//                .amount(200)
//                .price(0)
//                .image("https://media.giphy.com/media/3og0IPNcCRz8Tizbd6/giphy.gif")
//                .build();
//
//
//        Company company9 = Company.builder()
//                .name("Amazon")
//                .email("info@amazon.com")
//                .password("1234")
//                .coupons(null)
//                .build();
//
//        Coupon coupon9_1 = Coupon.builder()
//                .company(null)
//                .category(Category.GROCERIES)
//                .title("Prime Day Deals")
//                .description("Exclusive discounts on Diapers for Amazon Prime members")
//                .startDate(Date.valueOf(LocalDate.now()))
//                .endDate(Date.valueOf(LocalDate.now().plusDays(2)))
//                .amount(500)
//                .price(5)
//                .image("https://media.giphy.com/media/l2QDSKSkhqITBLYBy/giphy.gif")
//                .build();
//
//        Coupon coupon9_2 = Coupon.builder()
//                .company(null)
//                .category(Category.GROCERIES)
//                .title("Weekly Grocery Sale")
//                .description("Get 20% off on all amazon items this week")
//                .startDate(Date.valueOf(LocalDate.now()))
//                .endDate(Date.valueOf(LocalDate.now().plusWeeks(1)))
//                .amount(300)
//                .price(0)
//                .image("https://media.giphy.com/media/26xBDL9X2vhjHYVRm/giphy.gif")
//                .build();
//
//        Coupon coupon9_3 = Coupon.builder()
//                .company(null)
//                .category(Category.GROCERIES)
//                .title("Snack Bundle Offer")
//                .description("Buy 3 snacks and get the 4th one at half price")
//                .startDate(Date.valueOf(LocalDate.now()))
//                .endDate(Date.valueOf(LocalDate.now().plusWeeks(3)))
//                .amount(200)
//                .price(0)
//                .image("https://media.giphy.com/media/H9BjmV1zDeSnS/giphy.gif")
//                .build();
//
//
//        Customer customer1 = Customer.builder()
//                .firstName("Moshe")
//                .lastName("Yitzhaki")
//                .email("moshe@gmail.com")
//                .password("1234")
//                .build();
//
//        Customer customer2 = Customer.builder()
//                .firstName("Sarah")
//                .lastName("Johnson")
//                .email("sarah@gmail.com")
//                .password("1234")
//                .build();
//
//        Customer customer3 = Customer.builder()
//                .firstName("John")
//                .lastName("Doe")
//                .email("john@gmail.com")
//                .password("1234")
//                .build();
//
//
//        company1.addCoupons(List.of(coupon1_1, coupon1_2, coupon1_3));
//        company2.addCoupons(List.of(coupon2_1, coupon2_2, coupon2_3));
//        company3.addCoupons(List.of(coupon3_1, coupon3_2, coupon3_3));
//        company4.addCoupons(List.of(coupon4_1, coupon4_2, coupon4_3));
//        company5.addCoupons(List.of(coupon5_1, coupon5_2, coupon5_3));
//        company6.addCoupons(List.of(coupon6_1, coupon6_2, coupon6_3));
//        company7.addCoupons(List.of(coupon7_1, coupon7_2, coupon7_3));
//        company8.addCoupons(List.of(coupon8_1, coupon8_2, coupon8_3));
//        company9.addCoupons(List.of(coupon9_1, coupon9_2, coupon9_3));
//
//        customer1.setCoupons(List.of(coupon1_1, coupon5_2, coupon3_1));
//        customer2.setCoupons(List.of(coupon2_2, coupon8_3, coupon7_2));
//        customer3.setCoupons(List.of(coupon3_3, coupon4_1, coupon4_2));
//
//        companyRepo.saveAll(List.of(company1, company2, company3, company4, company5, company6, company7, company8, company9));
//        customerRepo.saveAll(List.of(customer1, customer2, customer3));
//    }
//}
