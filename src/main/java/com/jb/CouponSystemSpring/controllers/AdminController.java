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

    // TODO: 07/07/2023 make the service receive id and validate token here
    @Autowired
    private AdminService adminService;


    @PostMapping("/company")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCompany(@RequestHeader("Authorization") UUID token,
                           @RequestBody Company company) throws CouponException {
        adminService.addCompany(token, company);
    }

    @PutMapping("/company/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCompany(@RequestHeader("Authorization") UUID token,
                              @PathVariable int id,
                              @RequestBody Company company) throws CouponException {
        adminService.updateCompany(token, id, company);
    }

    @DeleteMapping("/company/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCompany(@RequestHeader("Authorization") UUID token,
                              @PathVariable int id) throws CouponException {
        adminService.deleteCompany(token, id);
    }

    @GetMapping("/company")
    public List<Company> getAllCompanies(@RequestHeader("Authorization") UUID token) throws CouponException {
        return adminService.getAllCompanies(token);
    }

    @GetMapping("/company/{id}")
    public Company getCompanyById(@RequestHeader("Authorization") UUID token,
                                  @PathVariable int id) throws CouponException {
        return adminService.getCompanyById(token, id);

    }

    @PostMapping("/customer")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCustomer(@RequestHeader("Authorization") UUID token,
                            @RequestBody Customer customer) throws CouponException {
        adminService.addCustomer(token, customer);
    }

    @PutMapping("/customer/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCustomer(@RequestHeader("Authorization") UUID token,
                               @PathVariable int id,
                               @RequestBody Customer customer) throws CouponException {
        adminService.updateCustomer(token, id, customer);
    }

    @DeleteMapping("/customer/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@RequestHeader("Authorization") UUID token,
                               @PathVariable int id) throws CouponException {
        adminService.deleteCustomer(token, id);
    }

    @GetMapping("/customer")
    public List<Customer> getAllCustomers(@RequestHeader("Authorization") UUID token) throws CouponException {
        return adminService.getAllCustomers(token);
    }

    @GetMapping("/customer/{id}")
    public Customer getCustomerById(@RequestHeader("Authorization") UUID token,
                                    @PathVariable int id) throws CouponException {
        return adminService.getCustomerById(token, id);
    }


}
