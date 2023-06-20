package com.targetindia.actuatordemo.repository;

import com.targetindia.actuatordemo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}
