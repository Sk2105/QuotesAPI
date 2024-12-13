package com.sk.quotesapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sk.quotesapi.services.CategoryServices;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryServices categoryServices;


    @GetMapping
    public ResponseEntity<?> getCategories() {
        return ResponseEntity.ok(categoryServices.getCategories());
    }

    
}
