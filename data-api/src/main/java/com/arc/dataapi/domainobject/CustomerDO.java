package com.arc.dataapi.domainobject;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "customer")
public class CustomerDO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long customerId;

    @Column(name = "name")
    @NotNull(message = "Customer name cant be null!")
    private String customerName;

    @Column(name = "active")
    @Type(type="boolean")
    private String customerActive;

    public CustomerDO() {
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerActive() {
        return customerActive;
    }

    public void setCustomerActive(String customerActive) {
        this.customerActive = customerActive;
    }
}
