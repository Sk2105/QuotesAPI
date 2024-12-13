package com.sk.quotesapi.dto;

public record QuoteDTO(
    String quote,
    String author,
    String category
) {
}
