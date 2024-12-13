package com.sk.quotesapi.controller;


import com.sk.quotesapi.responses.TokenResponse;
import com.sk.quotesapi.dto.UserDTO;
import com.sk.quotesapi.responses.UserNotFoundResponse;
import com.sk.quotesapi.entities.User;
import com.sk.quotesapi.jwt.JwtService;
import com.sk.quotesapi.responses.UserRegisterResponse;
import com.sk.quotesapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;


    @PostMapping("/register")
    public User registerUser(@RequestBody UserDTO user) throws RuntimeException {
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDTO user) {
        var userDetails = userService.loadUserByUsername(user.username());
        if (userDetails == null) {
            throw new UsernameNotFoundException("User not found with username: " + user.username());
        }
        return ResponseEntity.ok(new TokenResponse(
                jwtService.generateToken(user.username())
        ));
    }


    @ExceptionHandler
    public ResponseEntity<UserNotFoundResponse> handleException(UsernameNotFoundException e) {
        return ResponseEntity.badRequest().body(new UserNotFoundResponse(e.getMessage(), 400));
    }

    @ExceptionHandler
    public ResponseEntity<UserRegisterResponse> handleException(RuntimeException e) {
        return ResponseEntity.badRequest().body(new UserRegisterResponse(e.getMessage(), 400));
    }


}
