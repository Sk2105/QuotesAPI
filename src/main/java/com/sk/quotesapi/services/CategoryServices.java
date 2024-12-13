package com.sk.quotesapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sk.quotesapi.repository.CategoryRepo;

@Service
public class CategoryServices {


    @Autowired
    private CategoryRepo categoryRepo;


    public List<String> getCategories() {
        return categoryRepo.findAll()
                .stream()
                .map(category -> category.getName())
                .toList();
    }                               
    
}
