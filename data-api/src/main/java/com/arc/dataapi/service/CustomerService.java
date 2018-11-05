package com.arc.dataapi.service;



import com.arc.dataapi.domainobject.CustomerDO;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    Optional<CustomerDO> findCustomerById(Long id);

    Optional<CustomerDO> findCustomerByName(String name);

    CustomerDO saveCustomer(CustomerDO customerDO);

    void deleteCustomer(CustomerDO customerDO);

    List<CustomerDO> getAll();
}
