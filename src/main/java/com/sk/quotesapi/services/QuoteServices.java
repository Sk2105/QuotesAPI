package com.sk.quotesapi.services;

import com.sk.quotesapi.dto.QuoteDTO;
import com.sk.quotesapi.responses.QuoteResponse;
import com.sk.quotesapi.entities.Author;
import com.sk.quotesapi.entities.Category;
import com.sk.quotesapi.entities.QuoteItem;
import com.sk.quotesapi.repository.*;
import com.sk.quotesapi.repository.CategoryRepo;
import com.sk.quotesapi.repository.QuotesRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuoteServices {

    @Autowired
    private QuotesRepo quotesRepo;

    @Autowired
    private AuthorRepo authorRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    public List<QuoteResponse> getQuotes(int page, int size) throws RuntimeException {
        Pageable pageable = PageRequest.of(page, size);
        return quotesRepo.findAllQuotesResponse(pageable);
    }

    public List<QuoteResponse> getQuotesByCategory(String category, int page, int size) throws RuntimeException {
        Pageable pageable = PageRequest.of(page, size);
        return quotesRepo.findQuotesByCategoryResponse(category, pageable);
    }

    public List<QuoteResponse> getQuotesByAuthor(String author, int page, int size) throws RuntimeException {
        Pageable pageable = PageRequest.of(page, size);
        return quotesRepo.findQuotesByAuthorResponse(author, pageable);
    }

    public List<QuoteResponse> getQuotesByAuthorAndCategory(String author, String category, int page, int size) throws RuntimeException {
        Pageable pageable = PageRequest.of(page, size);
        return quotesRepo.findQuotesByAuthorAndCategoryResponse(author, category, pageable);
    }

    public QuoteResponse saveQuote(QuoteDTO quoteDTO) throws RuntimeException {
        QuoteItem savedQuoteItem = new QuoteItem();
        savedQuoteItem.setQuote(quoteDTO.quote());
        savedQuoteItem.setAuthor(findOrCreateAuthor(quoteDTO.author()));
        savedQuoteItem.setCategory(findOrCreateCategory(quoteDTO.category()));
        var savedQuote = quotesRepo.save(savedQuoteItem);

        return new QuoteResponse(savedQuote.getId(), savedQuote.getQuote(), savedQuote.getAuthor().getName(),
                savedQuote.getCategory().getName());
    }

    private Author findOrCreateAuthor(String authorName) {
        return authorRepo.findByName(authorName)
                .orElseGet(() -> {
                    Author newAuthor = new Author();
                    newAuthor.setName(authorName);
                    return authorRepo.save(newAuthor);
                });
    }

    private Category findOrCreateCategory(String categoryName) {
        return categoryRepo.findByName(categoryName)
                .orElseGet(() -> {
                    Category newCategory = new Category();
                    newCategory.setName(categoryName);
                    return categoryRepo.save(newCategory);
                });
    }

    public QuoteResponse quoteItemToQuoteResponse(String id) throws RuntimeException {
        try {
            return quotesRepo.findQuoteByIdResponse(id);
        } catch (Exception e) {
            throw new RuntimeException("Quote not found with id: " + id);
        }
    }

    public void deleteQuote(String id) {
        quotesRepo.deleteById(id);
    }


}
