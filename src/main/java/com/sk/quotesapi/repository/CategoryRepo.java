package com.sk.quotesapi.repository;

import com.sk.quotesapi.entities.Category;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, String> {

    Optional<Category> findByName(String name);
}
