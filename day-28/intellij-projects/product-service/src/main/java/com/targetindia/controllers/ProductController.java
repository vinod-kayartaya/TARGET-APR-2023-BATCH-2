package com.targetindia.controllers;

import com.targetindia.dao.ProductDao;
import com.targetindia.entity.Product;
import com.targetindia.model.Info;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @GetMapping(path = "/{productId}", produces = {"application/json", "application/xml"})
    public Product handleGetOneAsJson(@PathVariable int productId) {
        Product p = dao.findById(productId).get();
        return p;
    }

    @GetMapping(path = "/{productId}", produces = "text/plain")
    public String handleGetOneAsText(@PathVariable int productId) {
        Product p = dao.findById(productId).get();
        return p.toString();
    }

    @PostMapping(consumes = {"application/json", "application/xml"})
    public ResponseEntity handlePost(@RequestBody Product product) {
        product.setProductId(null);
        product = dao.save(product);
        return ResponseEntity.status(201).body(product);
    }

    @PutMapping(path = "/{productId}", consumes = {"application/json", "application/xml"})
    public ResponseEntity handlePut(@PathVariable Integer productId, @RequestBody Product product) {
        Optional<Product> result = dao.findById(productId);
        if (result.isPresent()) {
            product.setProductId(productId);
            dao.save(product);
            return ResponseEntity.ok(new Info("Product updated"));
        }
        return ResponseEntity.status(404).body(new Info("There is no product with this id"));
    }

    @DeleteMapping(path = "/{productId}", produces = {"application/json", "application/xml"})
    public ResponseEntity handleDelete(@PathVariable Integer productId) {
        Optional<Product> result = dao.findById(productId);
        if (result.isPresent()) {
            dao.deleteById(productId);
            return ResponseEntity.ok(result.get());
        }
        return ResponseEntity.status(404).body(new Info("There is no product with this id"));
    }


    @PatchMapping(path = "/{productId}", consumes = {"application/json", "application/xml"})
    public ResponseEntity handlePatch(@PathVariable Integer productId, @RequestBody Product product) {
        Optional<Product> result = dao.findById(productId);
        if (result.isEmpty()) {
            return ResponseEntity.status(404).body(new Info("There is no product with this id"));
        }

        Product p = result.get();
        product.setProductId(productId);
        if (product.getProductName() == null) {
            product.setProductName(p.getProductName());
        }
        if (product.getSupplierId() == null) {
            product.setSupplierId(p.getSupplierId());
        }
        if (product.getCategoryId() == null) {
            product.setCategoryId(p.getCategoryId());
        }
        if (product.getQuantityPerUnit() == null) {
            product.setQuantityPerUnit(p.getQuantityPerUnit());
        }
        if (product.getUnitPrice() == null) {
            product.setUnitPrice(p.getUnitPrice());
        }
        if (product.getUnitsInStock() == null) {
            product.setUnitsInStock(p.getUnitsInStock());
        }
        if (product.getUnitsOnOrder() == null) {
            product.setUnitsOnOrder(p.getUnitsOnOrder());
        }
        if (product.getReorderLevel() == null) {
            product.setReorderLevel(p.getReorderLevel());
        }
        if (product.getDiscontinued() == null) {
            product.setDiscontinued(p.getDiscontinued());
        }

        dao.save(product);
        return ResponseEntity.ok(product);
    }
}






