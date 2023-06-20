package com.targetindia.controllers;

import com.targetindia.dao.CategoryDao;
import com.targetindia.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    CategoryDao dao;

    @GetMapping(path = "/{id}", produces = {"application/json"})
    public ResponseEntity handleGetOne(@PathVariable Integer id) {
        if (dao.existsById(id)) {
            Category c = dao.findById(id).get();
            return ResponseEntity.ok(c);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping(produces = {"application/json"})
    public ResponseEntity handleGetAll() {
        return ResponseEntity.ok(dao.findAll());
    }
}
