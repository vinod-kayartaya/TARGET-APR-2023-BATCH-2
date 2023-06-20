package com.targetindia.controllers;

import com.targetindia.dao.ProductDao;
import com.targetindia.dto.CategoryDTO;
import com.targetindia.dto.ProductDTO;
import com.targetindia.dto.SupplierDTO;
import com.targetindia.entity.Product;
import com.targetindia.model.Info;
import com.targetindia.model.ProductList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.*;

@Slf4j
@RestController
@RequestMapping("/api/products")
public class ProductController {

    // dependency

    @Autowired
    private RestTemplate template;

    @Autowired
    private ProductDao dao;
    // spring injects the above dependency with an object of a class created on the fly
    // that implements the ProductDao

    // this class has methods that handle client requests (GET/POST/PUT/PATCH/DELETE)
    // We can use the specific annotations for the specific http request methods:
    // @GetMapping, @PostMapping, @PutMapping, @PatchMapping, @DeleteMapping
    // alternately @RequestMapping(method=RequestMethod.GET)

    @GetMapping(path = "/{productId}", produces = {"application/json", "application/xml"})
    public ResponseEntity handleGetOneAsJsonAndXml(
            @PathVariable int productId,
            @Value("${category.service.url}") String categoryServiceUrl,
            @Value("${supplier.service.url}") String supplierServiceUrl) {

        List<String> errors = new ArrayList<>();

        Optional<Product> result = dao.findById(productId);
        if (result.isPresent()) {
            Product p = result.get();

            CategoryDTO c1;

            try {
                WebClient client = WebClient.create(categoryServiceUrl + p.getCategoryId());
                c1 = client.get()
                        .retrieve()
                        .bodyToMono(CategoryDTO.class)
                        .block();
            } catch (Exception e) {
                errors.add("Couldn't get the category information.");
                c1 = null;
            }

            SupplierDTO s1;
            try{
                s1 = template.getForObject(supplierServiceUrl + p.getSupplierId(), SupplierDTO.class);
            }
            catch(Exception e){
                errors.add("Couldn't get the supplier information.");
                s1 = null;
            }

            ProductDTO p1 = new ProductDTO();
            p1.setProductId(p.getProductId());
            p1.setProductName(p.getProductName());
            p1.setCategory(c1);
            p1.setSupplier(s1);
            p1.setQuantityPerUnit(p.getQuantityPerUnit());
            p1.setUnitPrice(p.getUnitPrice());
            p1.setUnitsInStock(p.getUnitsInStock());
            p1.setUnitsOnOrder(p.getUnitsOnOrder());
            p1.setReorderLevel(p.getReorderLevel());
            p1.setDiscontinued(p.getDiscontinued());

            Map<String, Object> resp = new LinkedHashMap<>();
            resp.put("product", p1);
            if(!errors.isEmpty()){
                resp.put("errors", errors);
            }

            return ResponseEntity.ok(resp);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Info("No product found!"));
    }

    @GetMapping(path = "/{productId}", produces = "text/plain")
    public ResponseEntity handleGetOneAsText(@PathVariable int productId) {
        Optional<Product> result = dao.findById(productId);
        if (result.isPresent()) {
            return ResponseEntity.ok(result.get().toString());
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No product found!");
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

    @GetMapping(produces = {"application/json", "application/xml"})
    public ResponseEntity handleGetManyAsJsonAndXml(
            @RequestParam(name = "_page", defaultValue = "1") Integer pageNum,
            @RequestParam(name = "_limit", defaultValue = "5") Integer limit
    ) {
        Pageable p = PageRequest.of(pageNum - 1, limit);
        List<Product> list = dao.findAll(p).toList();
        log.trace("list is an instanceof {} class", list.getClass().getName());
        return ResponseEntity.ok(new ProductList(list));
    }

    @GetMapping(path = "/by/price", produces = {"application/json", "application/xml"})
    public ProductList handleGetByPriceRange(
            @RequestParam double min,
            @RequestParam double max
    ) {
        List<Product> list = dao.findAllByUnitPriceBetween(min, max);
        return new ProductList(list);
    }

    @GetMapping(path = "/by", produces = {"application/json", "application/xml"})
    public ResponseEntity handleGetByCategory(
            @RequestParam(name = "category", required = false) Integer categoryId,
            @RequestParam(name = "supplier", required = false) Integer supplierId) {

        if (categoryId == null && supplierId == null) {
            return ResponseEntity.status(400).body(new Info("either category id or supplier id required"));
        }
        List<Product> list;

        if (categoryId == null) {
            list = dao.findAllBySupplierId(supplierId);
        } else if (supplierId == null) {
            list = dao.findAllByCategoryId(categoryId);
        } else {
            list = dao.findAllBySupplierIdAndCategoryId(supplierId, categoryId);
        }
        return ResponseEntity.ok(new ProductList(list));
    }
}





















