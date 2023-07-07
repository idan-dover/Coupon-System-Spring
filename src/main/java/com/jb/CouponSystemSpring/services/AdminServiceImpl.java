package com.jb.CouponSystemSpring.services;

import com.jb.CouponSystemSpring.beans.Company;
import com.jb.CouponSystemSpring.beans.Customer;
import com.jb.CouponSystemSpring.exceptions.CouponException;
import com.jb.CouponSystemSpring.exceptions.ErrMsg;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl extends ClientService implements AdminService {


    @Override
    public void addCompany(Company company) throws CouponException {

        if (companyRepo.existsById(company.getId())) {
            throw new CouponException(ErrMsg.ID_ALREADY_EXISTS);
        }
        if (companyRepo.existsByName(company.getName())) {
            throw new CouponException(ErrMsg.NAME_ALREADY_EXISTS);
        }
        if (companyRepo.existsByEmail(company.getEmail())) {
            throw new CouponException(ErrMsg.EMAIL_ALREADY_EXISTS);
        }

        companyRepo.save(company);

    }

    @Override
    public void updateCompany(int companyId, Company toUpdate) throws CouponException {

        Company current = getCompanyById(companyId);

        if (current.getId() != toUpdate.getId()) {
            throw new CouponException(ErrMsg.NO_ID_FOUND);
        }

        if (!current.getEmail().equals(toUpdate.getEmail())) {
            throw new CouponException(ErrMsg.CANT_UPDATE_EMAIL);
        }

        companyRepo.saveAndFlush(toUpdate);
    }

    @Override
    public void deleteCompany(int companyId) throws CouponException {

        if (!companyRepo.existsById(companyId)) {
            throw new CouponException(ErrMsg.NO_ID_FOUND);
        }

        companyRepo.deleteById(companyId);
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepo.findAll();
    }

    @Override
    public Company getCompanyById(int companyId) throws CouponException {
        return companyRepo.findById(companyId).
                orElseThrow(() -> new CouponException(ErrMsg.NO_ID_FOUND));
    }

    @Override
    public void addCustomer(Customer customer) throws CouponException {
        if (customerRepo.existsById(customer.getId())) {
            throw new CouponException(ErrMsg.ID_ALREADY_EXISTS);
        }

        if (customerRepo.existsByEmail(customer.getEmail())) {
            throw new CouponException(ErrMsg.EMAIL_ALREADY_EXISTS);
        }

        customerRepo.save(customer);
    }

    @Override
    public void updateCustomer(int customerId, Customer toUpdate) throws CouponException {
        Customer current = customerRepo.findById(customerId)
                .orElseThrow(() -> new CouponException(ErrMsg.NO_ID_FOUND));

        if (current.getId() != toUpdate.getId()) {
            throw new CouponException(ErrMsg.NO_ID_FOUND);
        }

        if (!current.getEmail().equals(toUpdate.getEmail())) {
            throw new CouponException(ErrMsg.CANT_UPDATE_EMAIL);
        }

        customerRepo.saveAndFlush(toUpdate);
    }

    @Override
    public void deleteCustomer(int customerId) throws CouponException {
        if (!customerRepo.existsById(customerId)) {
            throw new CouponException(ErrMsg.NO_ID_FOUND);
        }


        customerRepo.deleteById(customerId);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }

    @Override
    public Customer getCustomerById(int customerId) throws CouponException {
        return customerRepo.findById(customerId)
                .orElseThrow(() -> new CouponException(ErrMsg.NO_ID_FOUND));
    }


}
