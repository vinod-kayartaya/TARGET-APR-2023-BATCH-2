package com.targetindia.supplierservice.repository;

import com.targetindia.supplierservice.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
}
