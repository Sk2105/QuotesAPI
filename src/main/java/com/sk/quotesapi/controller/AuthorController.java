package com.sk.quotesapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sk.quotesapi.services.AuthorServices;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorServices authorServices;


    @GetMapping
    public ResponseEntity<?> getAuthors() {
        return ResponseEntity.ok(authorServices.getAuthors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAuthor(@PathVariable String id) {
        return ResponseEntity.ok(authorServices.getAuthor(id));
    }

    
}
