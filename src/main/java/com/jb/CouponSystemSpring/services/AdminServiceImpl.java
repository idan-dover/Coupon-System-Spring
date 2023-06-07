package com.jb.CouponSystemSpring.services;

import com.jb.CouponSystemSpring.beans.Company;
import com.jb.CouponSystemSpring.beans.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl extends ClientService implements AdminService{
    @Override
    public void addCompany(Company company) {

    }

    @Override
    public void updateCompany(int companyId, Company company) {

    }

    @Override
    public void deleteCompany(int companyId) {

    }

    @Override
    public List<Company> getAllCompanies() {
        return null;
    }

    @Override
    public Company getCompanyById(int companyId) {
        return null;
    }

    @Override
    public void addCustomer(Customer customer) {

    }

    @Override
    public void updateCustomer(int customerId, Customer customer) {

    }

    @Override
    public void deleteCustomer(int customerId) {

    }
}
