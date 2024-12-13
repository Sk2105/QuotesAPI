package com.sk.quotesapi.repository;

import com.sk.quotesapi.entities.QuoteItem;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.sk.quotesapi.responses.*;

@Repository
public interface QuotesRepo extends JpaRepository<QuoteItem, String> {

    @Query("SELECT q.id, q.quote, a.name as author, c.name as category FROM QuoteItem q JOIN q.author a JOIN q.category c")
    List<Object[]> findAllQuotes();


    default List<QuoteResponse> findAllQuotesResponse() {
        return convertQuotesToResponse(findAllQuotes());
    }

    @Query("SELECT q.id, q.quote, a.name as author, c.name as category FROM QuoteItem q JOIN q.author a JOIN q.category c")
    List<Object[]> findAllQuotes(Pageable pageable);


    default List<QuoteResponse> findAllQuotesResponse(Pageable pageable) {
        return convertQuotesToResponse(findAllQuotes(pageable));
    }


    @Query("SELECT q.id, q.quote, a.name as author, c.name as category FROM QuoteItem q JOIN q.author a JOIN q.category c WHERE q.id = :id")
    List<Object[]> findQuoteById(String id);

    default QuoteResponse findQuoteByIdResponse(String id) {
        return convertQuotesToResponse(findQuoteById(id)).get(0);
    }

    /**
     * Find all quotes by a given author.
     *
     * @param authorName The name of the author.
     * @return A list of QuoteResponse objects, each containing the id, quote,
     * author and category.
     */
    @Query("SELECT q.id, q.quote, a.name as author, c.name as category FROM QuoteItem q JOIN q.author a JOIN q.category c WHERE a.name = :authorName")
    List<Object[]> findQuotesByAuthor(String authorName, Pageable pageable);

    default List<QuoteResponse> findQuotesByAuthorResponse(String authorName, Pageable pageable) {
        return convertQuotesToResponse(findQuotesByAuthor(authorName, pageable));
    }

    @Query("SELECT q.id, q.quote, a.name as author, c.name as category FROM QuoteItem q JOIN q.author a JOIN q.category c WHERE c.name = :categoryName")
    List<Object[]> findQuotesByCategory(String categoryName, Pageable pageable);

    default List<QuoteResponse> findQuotesByCategoryResponse(String categoryName, Pageable pageable) {
        return convertQuotesToResponse(findQuotesByCategory(categoryName, pageable));
    }

    @Query("SELECT q.id, q.quote, a.name as author, c.name as category FROM QuoteItem q JOIN q.author a JOIN q.category c WHERE a.name = :author AND c.name = :category")
    List<Object[]> findQuotesByAuthorAndCategory(String author, String category, Pageable pageable);

    default List<QuoteResponse> findQuotesByAuthorAndCategoryResponse(String author, String category, Pageable pageable) {
        return convertQuotesToResponse(findQuotesByAuthorAndCategory(author, category, pageable));
    }

    private List<QuoteResponse> convertQuotesToResponse(List<Object[]> quotes) {
        List<QuoteResponse> responses = new ArrayList<>();
        for (Object[] quote : quotes) {
            responses
                    .add(new QuoteResponse((String) quote[0], (String) quote[1], (String) quote[2], (String) quote[3]));
        }
        return responses;
    }
}
