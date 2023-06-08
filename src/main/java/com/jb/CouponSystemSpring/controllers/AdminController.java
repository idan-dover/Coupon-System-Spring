package com.jb.CouponSystemSpring.controllers;

import com.jb.CouponSystemSpring.Exceptions.CouponException;
import com.jb.CouponSystemSpring.beans.Company;
import com.jb.CouponSystemSpring.beans.Customer;
import com.jb.CouponSystemSpring.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @PostMapping("/company")
    public void addCompany(@RequestBody Company company) throws CouponException {
        adminService.addCompany(company);
    }

    @PutMapping("/company/id")
    public void updateCompany(@RequestParam int val,@RequestBody Company company) throws CouponException {
        adminService.updateCompany(val, company);
    }

    @DeleteMapping("/company/id")
    public void deleteCompany(@RequestParam int val) throws CouponException {
        adminService.deleteCompany(val);
    }

    @GetMapping("/company")
    public List<Company> getAllCompanies() {
        return adminService.getAllCompanies();
    }

    @GetMapping("/company/id")
    public Company getCompanyById(@RequestParam int val) throws CouponException {
        return adminService.getCompanyById(val);

    }
    @PostMapping("/customer")
    public void addCustomer(@RequestBody Customer customer) throws CouponException {
        adminService.addCustomer(customer);
    }

    @PutMapping("/customer/id")
    public void updateCustomer(@RequestParam int val, @RequestBody Customer customer) throws CouponException {
        adminService.updateCustomer(val, customer);
    }

    @DeleteMapping("/customer/id")
    public void deleteCustomer(@RequestParam int val) throws CouponException {
        adminService.deleteCustomer(val);
    }

    @GetMapping("/customer")
    public List<Customer> getAllCustomers() {
        return adminService.getAllCustomers();
    }

    @GetMapping("/customer/id")
    public Customer getCustomerById(@RequestParam int val) throws CouponException {
        return adminService.getCustomerById(val);
    }




}
