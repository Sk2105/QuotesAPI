package com.sk.quotesapi.responses;

public record UserNotFoundResponse(
        String message,
        int status
) {
}
