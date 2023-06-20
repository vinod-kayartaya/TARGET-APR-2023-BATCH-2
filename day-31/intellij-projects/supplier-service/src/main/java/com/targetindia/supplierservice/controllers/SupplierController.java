package com.targetindia.supplierservice.controllers;

import com.targetindia.supplierservice.entity.Supplier;
import com.targetindia.supplierservice.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {

    @Autowired
    SupplierRepository repo;

    @GetMapping("/{supplierId}")
    public ResponseEntity handleGetOne(@PathVariable Integer supplierId){
        Optional<Supplier> result = repo.findById(supplierId);
        if(result.isPresent()){
            return ResponseEntity.ok(result.get());
        }

        return ResponseEntity.notFound().build();
    }

}
