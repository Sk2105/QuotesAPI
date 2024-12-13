package com.sk.quotesapi.repository;

import com.sk.quotesapi.entities.Author;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface AuthorRepo extends JpaRepository<Author, String> {
    Optional<Author> findByName(String name);
}
