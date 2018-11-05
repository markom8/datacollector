package com.arc.dataapi.dataaccessobject;


import com.arc.dataapi.domainobject.CustomerDO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends CrudRepository<CustomerDO, Long> {
    Optional<CustomerDO> findCustomerDOByCustomerName(String customerName);
}
