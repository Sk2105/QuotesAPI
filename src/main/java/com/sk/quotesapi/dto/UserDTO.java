package com.sk.quotesapi.dto;

public record UserDTO(
        String username,
        String email,
        String password
) {
}
