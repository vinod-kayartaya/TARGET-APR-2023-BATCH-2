package com.targetindia.controllers;

import com.targetindia.entity.Category;
import com.targetindia.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryRepository repo;

    @GetMapping(path = "/{categoryId}", produces = "application/json")
    public ResponseEntity handleGetOne(@PathVariable Integer categoryId){
        Optional<Category> result = repo.findById(categoryId);
        if(result.isPresent()){
            return ResponseEntity.ok(result.get());
        }

        return ResponseEntity.notFound().build();
    }
}
