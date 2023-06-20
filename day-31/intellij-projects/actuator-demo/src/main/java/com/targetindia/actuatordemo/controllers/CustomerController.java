package com.targetindia.actuatordemo.controllers;

import com.targetindia.actuatordemo.entity.Customer;
import com.targetindia.actuatordemo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository repo;

    @GetMapping(path = "/{customerId}", produces = "application/json")
    public ResponseEntity handleGetOne(@PathVariable String customerId) {
        Optional<Customer> result = repo.findById(customerId);
        if (result.isEmpty()) {
            Map<String, Object> map = new HashMap<>();
            map.put("message", "No customer found for id " + customerId);
            map.put("timestamp", new Date());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
        }

        return ResponseEntity.ok(result.get());
    }
}
