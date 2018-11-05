package com.arc.dataapi.service;


import com.arc.dataapi.dataaccessobject.CustomerRepository;
import com.arc.dataapi.domainobject.CustomerDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Optional<CustomerDO> findCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public Optional<CustomerDO> findCustomerByName(String name) {
        return customerRepository.findCustomerDOByCustomerName(name);
    }

    @Override
    public CustomerDO saveCustomer(CustomerDO customerDO) {
        return customerRepository.save(customerDO);
    }

    @Override
    public void deleteCustomer(CustomerDO customerDO) {
        customerRepository.delete(customerDO);
    }

    @Override
    public List<CustomerDO> getAll() {
        return (List<CustomerDO>) customerRepository.findAll();
    }
}
