package com.jb.CouponSystemSpring.services;

import com.jb.CouponSystemSpring.Exceptions.CouponException;
import com.jb.CouponSystemSpring.beans.Company;
import com.jb.CouponSystemSpring.beans.Customer;

import java.util.List;

public interface AdminService {

    void addCompany(Company company) throws CouponException;

    void updateCompany(int companyId, Company company) throws CouponException;

    void deleteCompany(int companyId) throws CouponException;

    List<Company> getAllCompanies() throws CouponException;

    Company getCompanyById(int companyId) throws CouponException;

    void addCustomer(Customer customer) throws CouponException;

    void updateCustomer(int customerId, Customer customer) throws CouponException;

    void deleteCustomer(int customerId) throws CouponException;

    List<Customer> getAllCustomers() throws CouponException;

    Customer getCustomerById(int customerId) throws CouponException;
}
