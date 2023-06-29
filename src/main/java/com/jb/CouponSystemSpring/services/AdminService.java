package com.jb.CouponSystemSpring.services;

import com.jb.CouponSystemSpring.Exceptions.CouponException;
import com.jb.CouponSystemSpring.beans.Company;
import com.jb.CouponSystemSpring.beans.Customer;

import java.util.List;
import java.util.UUID;

public interface AdminService {

    void addCompany(UUID token, Company company) throws CouponException;

    void updateCompany(UUID token, int companyId, Company company) throws CouponException;

    void deleteCompany(UUID token, int companyId) throws CouponException;

    List<Company> getAllCompanies(UUID token) throws CouponException;

    Company getCompanyById(UUID token, int companyId) throws CouponException;

    void addCustomer(UUID token, Customer customer) throws CouponException;

    void updateCustomer(UUID token, int customerId, Customer customer) throws CouponException;

    void deleteCustomer(UUID token, int customerId) throws CouponException;

    List<Customer> getAllCustomers(UUID token) throws CouponException;

    Customer getCustomerById(UUID token, int customerId) throws CouponException;
}
