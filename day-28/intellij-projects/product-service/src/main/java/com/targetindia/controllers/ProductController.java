package com.targetindia.controllers;

import com.targetindia.ProductDao;
import com.targetindia.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/products")
public class ProductController {

    // dependency
    @Autowired
    private ProductDao dao;
    // spring injects the above dependency with an object of a class created on the fly
    // that implements the ProductDao

    // this class has methods that handle client requests (GET/POST/PUT/PATCH/DELETE)
    // We can use the specific annotations for the specific http request methods:
    // @GetMapping, @PostMapping, @PutMapping, @PatchMapping, @DeleteMapping
    // alternately @RequestMapping(method=RequestMethod.GET)

    @GetMapping("/{productId}")
    public Product handleGetOne(@PathVariable int productId) {
        log.debug("got a request for a product with id {}", productId);
        Product p = dao.findById(productId).get();
        log.debug("p = {}", p);
        return p;
    }
}
