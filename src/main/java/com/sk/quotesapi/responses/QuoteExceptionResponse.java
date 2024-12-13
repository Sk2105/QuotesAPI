package com.sk.quotesapi.responses;

public record QuoteExceptionResponse(
        String message,
        int status) {

}
