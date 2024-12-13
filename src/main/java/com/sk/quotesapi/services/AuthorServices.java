package com.sk.quotesapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sk.quotesapi.responses.AuthorResponse;
import com.sk.quotesapi.repository.AuthorRepo;

@Service
public class AuthorServices {

    @Autowired
    private AuthorRepo authorRepo;

    public List<AuthorResponse> getAuthors() {
        return authorRepo.findAll()
                .stream()
                .map(author -> new AuthorResponse(author.getId(), author.getName()))
                .toList();
    }

    public AuthorResponse getAuthor(String id) {
        return authorRepo.findById(id)
                .map(author -> new AuthorResponse(author.getId(), author.getName()))
                .orElse(null);
    }

}
