package com.agency.digital_agency.service;

import com.agency.digital_agency.model.User;
import com.agency.digital_agency.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // The parameter from the login form is the username
        System.out.println(">>> [LOGIN] Attempting to load user by USERNAME: " + username);

        // ✅ CHANGE THIS LINE
        // FROM: User user = userRepository.findByEmail(username);
        // TO:
        User user = userRepository.findByUsername(username);

        if (user != null) {
            System.out.println(">>> [LOGIN] User found. Stored hash is: " + user.getPassword());
            return new org.springframework.security.core.userdetails.User(
                // IMPORTANT: The first parameter here MUST be the unique identifier used for login.
                // It should match what's in the database and what's used in the query.
                user.getUsername(),
                user.getPassword(),
                user.getRoles().stream()
                        .map(role -> new SimpleGrantedAuthority(role.getName()))
                        .collect(Collectors.toList())
            );
        } else {
            System.out.println(">>> [LOGIN] User NOT found with username: " + username);
            throw new UsernameNotFoundException("Invalid username or password.");
        }
    }
}