package com.sk.quotesapi.controller;

import com.sk.quotesapi.dto.QuoteDTO;
import com.sk.quotesapi.responses.QuoteExceptionResponse;
import com.sk.quotesapi.services.QuoteServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/quotes")
public class QuotesController {

    @Autowired
    private QuoteServices quoteServices;

    @GetMapping
    public ResponseEntity<?> getAllQuotes(
            @RequestParam(name = "author", required = false, defaultValue = "All") String author,
            @RequestParam(name = "category", required = false, defaultValue = "All") String category,
            @RequestParam(name = "page", required = false, defaultValue = "0") int page,
            @RequestParam(name = "size", required = false, defaultValue = "100") int size

    ) throws RuntimeException {
        if (author.equals("All") && category.equals("All")) {
            return ResponseEntity.ok(quoteServices.getQuotes(page, size));
        } else if (author.equals("All")) {
            return ResponseEntity.ok(quoteServices.getQuotesByCategory(category, page, size));
        } else if (category.equals("All")) {
            return ResponseEntity.ok(quoteServices.getQuotesByAuthor(author, page, size));
        } else {
            return ResponseEntity.ok(quoteServices.getQuotesByAuthorAndCategory(author, category, page, size));
        }
    }

    @PostMapping
    public ResponseEntity<?> saveQuote(@RequestBody QuoteDTO quoteItem) throws RuntimeException {
        return ResponseEntity.ok(quoteServices.saveQuote(quoteItem));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getQuote(@PathVariable String id) throws RuntimeException {
        return ResponseEntity.ok(quoteServices.quoteItemToQuoteResponse(id));
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> deleteQuote(@PathVariable String id) {
        quoteServices.deleteQuote(id);
        return ResponseEntity.ok("Quote deleted successfully");
    }

    @ExceptionHandler
    public ResponseEntity<?> handleException(RuntimeException e) {
        QuoteExceptionResponse quoteExceptionResponse = new QuoteExceptionResponse(e.getMessage(), 400);
        return ResponseEntity.badRequest().body(quoteExceptionResponse);
    }

}
