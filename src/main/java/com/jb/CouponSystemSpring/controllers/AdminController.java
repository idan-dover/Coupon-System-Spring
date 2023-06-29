package com.jb.CouponSystemSpring.controllers;

import com.jb.CouponSystemSpring.Exceptions.CouponException;
import com.jb.CouponSystemSpring.beans.Company;
import com.jb.CouponSystemSpring.beans.Customer;
import com.jb.CouponSystemSpring.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/company")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCompany(@RequestHeader("Authorization") UUID token, @RequestBody Company company) throws CouponException {
        adminService.addCompany(token, company);
    }

    @PutMapping("/company/id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCompany(@RequestHeader("Authorization") UUID token, @RequestParam int val, @RequestBody Company company) throws CouponException {
        adminService.updateCompany(token, val, company);
    }

    @DeleteMapping("/company/id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCompany(@RequestHeader("Authorization") UUID token, @RequestParam int val) throws CouponException {
        adminService.deleteCompany(token, val);
    }

    @GetMapping("/company")
    public List<Company> getAllCompanies(@RequestHeader("Authorization") UUID token) throws CouponException {
        return adminService.getAllCompanies(token);
    }

    @GetMapping("/company/id")
    public Company getCompanyById(@RequestHeader("Authorization") UUID token, @RequestParam int val) throws CouponException {
        return adminService.getCompanyById(token, val);

    }

    @PostMapping("/customer")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCustomer(@RequestHeader("Authorization") UUID token, @RequestBody Customer customer) throws CouponException {
        adminService.addCustomer(token, customer);
    }

    @PutMapping("/customer/id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCustomer(@RequestHeader("Authorization") UUID token, @RequestParam int val, @RequestBody Customer customer) throws CouponException {
        adminService.updateCustomer(token, val, customer);
    }

    @DeleteMapping("/customer/id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@RequestHeader("Authorization") UUID token, @RequestParam int val) throws CouponException {
        adminService.deleteCustomer(token, val);
    }

    @GetMapping("/customer")
    public List<Customer> getAllCustomers(@RequestHeader("Authorization") UUID token) throws CouponException {
        return adminService.getAllCustomers(token);
    }

    @GetMapping("/customer/id")
    public Customer getCustomerById(@RequestHeader("Authorization") UUID token, @RequestParam int val) throws CouponException {
        return adminService.getCustomerById(token, val);
    }


}
