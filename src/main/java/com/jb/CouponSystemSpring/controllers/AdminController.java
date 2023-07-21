package com.jb.CouponSystemSpring.controllers;

import com.jb.CouponSystemSpring.beans.Company;
import com.jb.CouponSystemSpring.beans.Customer;
import com.jb.CouponSystemSpring.exceptions.CouponException;
import com.jb.CouponSystemSpring.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/companies")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCompany(@RequestBody Company company) throws CouponException {
        adminService.addCompany(company);
    }

    @PutMapping("/companies/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCompany(@PathVariable int id,
                              @RequestBody Company company) throws CouponException {
        adminService.updateCompany(id, company);
    }

    @DeleteMapping("/companies/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCompany(@PathVariable int id) throws CouponException {
        adminService.deleteCompany(id);
    }

    @GetMapping("/companies")
    public List<Company> getAllCompanies() throws CouponException {
        return adminService.getAllCompanies();
    }

    @GetMapping("/companies/{id}")
    public Company getCompanyById(@PathVariable int id) throws CouponException {
        return adminService.getCompanyById(id);

    }

    @PostMapping("/customers")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCustomer(@RequestBody Customer customer) throws CouponException {
        adminService.addCustomer(customer);
    }

    @PutMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCustomer(@PathVariable int id,
                               @RequestBody Customer customer) throws CouponException {
        adminService.updateCustomer(id, customer);
    }

    @DeleteMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable int id) throws CouponException {
        adminService.deleteCustomer(id);
    }

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() throws CouponException {
        return adminService.getAllCustomers();
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable int id) throws CouponException {
        return adminService.getCustomerById(id);
    }


}
