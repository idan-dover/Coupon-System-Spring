package com.jb.CouponSystemSpring.controllers;

import com.jb.CouponSystemSpring.Exceptions.CouponException;
import com.jb.CouponSystemSpring.beans.Company;
import com.jb.CouponSystemSpring.beans.Customer;
import com.jb.CouponSystemSpring.models.ClientType;
import com.jb.CouponSystemSpring.security.TokenService;
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

    @Autowired
    private TokenService tokenService;

    @PostMapping("/company")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCompany(@RequestHeader("Authorization") UUID token,
                           @RequestBody Company company) throws CouponException {
        tokenService.validate(token, ClientType.ADMIN);
        adminService.addCompany(company);
    }

    @PutMapping("/company/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCompany(@RequestHeader("Authorization") UUID token,
                              @PathVariable int id,
                              @RequestBody Company company) throws CouponException {
        tokenService.validate(token, ClientType.ADMIN);
        adminService.updateCompany(id, company);
    }

    @DeleteMapping("/company/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCompany(@RequestHeader("Authorization") UUID token,
                              @PathVariable int id) throws CouponException {
        tokenService.validate(token, ClientType.ADMIN);
        adminService.deleteCompany(id);
    }

    @GetMapping("/company")
    public List<Company> getAllCompanies(@RequestHeader("Authorization") UUID token) throws CouponException {
        tokenService.validate(token, ClientType.ADMIN);
        return adminService.getAllCompanies();
    }

    @GetMapping("/company/{id}")
    public Company getCompanyById(@RequestHeader("Authorization") UUID token,
                                  @PathVariable int id) throws CouponException {
        tokenService.validate(token, ClientType.ADMIN);
        return adminService.getCompanyById(id);

    }

    @PostMapping("/customer")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCustomer(@RequestHeader("Authorization") UUID token,
                            @RequestBody Customer customer) throws CouponException {
        tokenService.validate(token, ClientType.ADMIN);
        adminService.addCustomer(customer);
    }

    @PutMapping("/customer/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCustomer(@RequestHeader("Authorization") UUID token,
                               @PathVariable int id,
                               @RequestBody Customer customer) throws CouponException {
        tokenService.validate(token, ClientType.ADMIN);
        adminService.updateCustomer(id, customer);
    }

    @DeleteMapping("/customer/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@RequestHeader("Authorization") UUID token,
                               @PathVariable int id) throws CouponException {
        tokenService.validate(token, ClientType.ADMIN);
        adminService.deleteCustomer(id);
    }

    @GetMapping("/customer")
    public List<Customer> getAllCustomers(@RequestHeader("Authorization") UUID token) throws CouponException {
        tokenService.validate(token, ClientType.ADMIN);
        return adminService.getAllCustomers();
    }

    @GetMapping("/customer/{id}")
    public Customer getCustomerById(@RequestHeader("Authorization") UUID token,
                                    @PathVariable int id) throws CouponException {
        tokenService.validate(token, ClientType.ADMIN);
        return adminService.getCustomerById(id);
    }


}
