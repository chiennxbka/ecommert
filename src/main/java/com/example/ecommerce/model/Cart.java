package com.example.ecommerce.model;

import javax.persistence.*;

@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @Column(name="id", nullable=false, unique=true)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column(name = "customerNumber")
    private int customerNumber;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }
}
