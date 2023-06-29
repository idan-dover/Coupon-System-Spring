package com.jb.CouponSystemSpring.services;

import com.jb.CouponSystemSpring.Exceptions.CouponException;
import com.jb.CouponSystemSpring.Exceptions.ErrMsg;
import com.jb.CouponSystemSpring.beans.Company;
import com.jb.CouponSystemSpring.beans.Customer;
import com.jb.CouponSystemSpring.models.ClientType;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AdminServiceImpl extends ClientService implements AdminService {

    private final ClientType type = ClientType.ADMIN;

    @Override
    public void addCompany(UUID token, Company company) throws CouponException {
        checkIfClientAllowed(token, type);

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
    public void updateCompany(UUID token, int companyId, Company toUpdate) throws CouponException {
        checkIfClientAllowed(token, type);

        Company current = getCompanyById(token, companyId);

        if (current.getId() != toUpdate.getId()) {
            throw new CouponException(ErrMsg.NO_ID_FOUND);
        }

        if (!current.getEmail().equals(toUpdate.getEmail())) {
            throw new CouponException(ErrMsg.CANT_UPDATE_EMAIL);
        }

        companyRepo.saveAndFlush(toUpdate);
    }

    @Override
    public void deleteCompany(UUID token, int companyId) throws CouponException {
        checkIfClientAllowed(token, type);

        if (!companyRepo.existsById(companyId)) {
            throw new CouponException(ErrMsg.NO_ID_FOUND);
        }

        companyRepo.deleteById(companyId);
    }

    @Override
    public List<Company> getAllCompanies(UUID token) throws CouponException {
        checkIfClientAllowed(token, type);
        return companyRepo.findAll();
    }

    @Override
    public Company getCompanyById(UUID token, int companyId) throws CouponException {
        checkIfClientAllowed(token, type);
        return companyRepo.findById(companyId).
                orElseThrow(() -> new CouponException(ErrMsg.NO_ID_FOUND));
    }

    @Override
    public void addCustomer(UUID token, Customer customer) throws CouponException {
        checkIfClientAllowed(token, type);
        if (customerRepo.existsById(customer.getId())) {
            throw new CouponException(ErrMsg.ID_ALREADY_EXISTS);
        }

        if (customerRepo.existsByEmail(customer.getEmail())) {
            throw new CouponException(ErrMsg.EMAIL_ALREADY_EXISTS);
        }

        customerRepo.save(customer);
    }

    @Override
    public void updateCustomer(UUID token, int customerId, Customer toUpdate) throws CouponException {
        checkIfClientAllowed(token, type);
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
    public void deleteCustomer(UUID token, int customerId) throws CouponException {
        checkIfClientAllowed(token, type);
        if (!customerRepo.existsById(customerId)) {
            throw new CouponException(ErrMsg.NO_ID_FOUND);
        }


        customerRepo.deleteById(customerId);
    }

    @Override
    public List<Customer> getAllCustomers(UUID token) throws CouponException {
        checkIfClientAllowed(token, type);
        return customerRepo.findAll();
    }

    @Override
    public Customer getCustomerById(UUID token, int customerId) throws CouponException {
        checkIfClientAllowed(token, type);
        return customerRepo.findById(customerId)
                .orElseThrow(() -> new CouponException(ErrMsg.NO_ID_FOUND));
    }


}
