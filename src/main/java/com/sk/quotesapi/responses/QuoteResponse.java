package com.sk.quotesapi.responses;

public record QuoteResponse(
    String id,
    String quotes,
    String author,
    String category
) {
    
}
