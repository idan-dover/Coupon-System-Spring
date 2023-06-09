package com.jb.CouponSystemSpring.clr;

import com.jb.CouponSystemSpring.beans.Company;
import com.jb.CouponSystemSpring.beans.Customer;
import com.jb.CouponSystemSpring.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

//@Component
//@Order(2)
public class AdminServiceClr implements CommandLineRunner {

    @Autowired
    AdminService adminService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ __ADMIN SERVICE__ @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ ADDING NEW COMPANY @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        Company company1 = Company.builder()
                .id(1)
                .name("Nike")
                .email("info@nike.com")
                .password("5678")
                .build();

        try {
            adminService.addCompany(company1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        company1.setId(0);

        try {
            adminService.addCompany(company1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        company1.setName("IKEA");

        try {
            adminService.addCompany(company1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        company1.setEmail("info@ikea.com");

        adminService.addCompany(company1);
        adminService.getAllCompanies().forEach(System.out::println);

        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ UPDATING NEW COMPANY @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

        try {
            adminService.updateCompany(0, company1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        company1.setId(2);
        String companyEmail = company1.getEmail();
        company1.setEmail("I know this won't work");


        try {
            adminService.updateCompany(company1.getId(), company1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        company1.setEmail(companyEmail);
        company1.setName("update");
        company1.setPassword("1234");

        adminService.updateCompany(company1.getId(), company1);
        adminService.getAllCompanies().forEach(System.out::println);

        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ DELETING COMPANY @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        try {
            adminService.deleteCompany(1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        adminService.getAllCompanies().forEach(System.out::println);

        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ ADDING NEW CUSTOMER @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

        Customer customer1 = Customer.builder()
                .id(1)
                .firstName("Idan")
                .lastName("Dover")
                .email("moshe@gmail.com")
                .password("1234")
                .build();

        try {
            adminService.addCustomer(customer1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        customer1.setId(0);

        try {
            adminService.addCustomer(customer1);
        } catch (Exception e) {
            System.out.println(e.getMessage());

            customer1.setEmail("idan@gmail.com");

        }
        try {
            adminService.addCustomer(customer1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        adminService.getAllCustomers().forEach(System.out::println);

        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ UPDATING CUSTOMER @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        customer1.setFirstName("David");
        customer1.setEmail("david@gmail.com");
        try {
            adminService.updateCustomer(customer1.getId(), customer1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        adminService.getAllCustomers().forEach(System.out::println);

        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ DELETING CUSTOMER @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        try {
            adminService.deleteCustomer(1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        adminService.getAllCustomers().forEach(System.out::println);
    }
}
