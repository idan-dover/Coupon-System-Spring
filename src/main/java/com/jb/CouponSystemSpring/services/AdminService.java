package com.jb.CouponSystemSpring.services;

import com.jb.CouponSystemSpring.beans.Company;
import com.jb.CouponSystemSpring.beans.Customer;

import java.util.List;

public interface AdminService {

    void addCompany(Company company);

    void updateCompany(int companyId, Company company);

    void deleteCompany(int companyId);

    List<Company> getAllCompanies();

    Company getCompanyById(int companyId);

    void addCustomer(Customer customer);

    void updateCustomer(int customerId, Customer customer);

    void deleteCustomer(int customerId);
}
