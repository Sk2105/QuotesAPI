package com.sk.quotesapi.services;


import com.sk.quotesapi.dto.UserDTO;
import com.sk.quotesapi.entities.User;
import com.sk.quotesapi.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public User registerUser(UserDTO userDTO) throws RuntimeException {
        User user = toUser(userDTO);
        return userRepo.save(user);
    }

    private User toUser(UserDTO userDTO) throws RuntimeException {
        User user = new User();
        user.setUsername(userDTO.username());
        user.setPassword(passwordEncoder.encode(userDTO.password()));
        user.setEmail(userDTO.email());
        return user;
    }

    public User findByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    public User findByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    public User findById(String id) {
        return userRepo.findById(id).orElse(null);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            var user = userRepo.findByUsername(username);
            return user;
        } catch (Exception e) {
            throw new UsernameNotFoundException("User not found");
        }

    }
}
