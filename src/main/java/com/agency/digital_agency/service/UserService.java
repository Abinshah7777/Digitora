package com.agency.digital_agency.service;

import com.agency.digital_agency.model.Role;
import com.agency.digital_agency.model.User;
import com.agency.digital_agency.Repository.RoleRepository;
import com.agency.digital_agency.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void register(User user) {
        // 1. Check if a user with this email already exists to prevent errors.
        if (userRepository.findByEmail(user.getEmail()) != null) {
            // In a real application, you would throw a custom exception here.
            System.out.println("User with this email already exists: " + user.getEmail());
            return; // Stop the registration process.
        }
        // --- DEBUG LINE 1: See the raw password ---
        System.out.println(">>> [REGISTER] Raw Password: " + user.getPassword());

        String encodedPassword = passwordEncoder.encode(user.getPassword());

        // --- DEBUG LINE 2: See the EXACT hash being saved ---
        System.out.println(">>> [REGISTER] Encoded Password to be saved: " + encodedPassword);

        user.setPassword(encodedPassword);

        // 3. Find the default role "ROLE_USER".
        Role userRole = roleRepository.findByName("ROLE_USER");

        // 4. ROBUSTNESS FIX: If the role doesn't exist in the database, create it.
        //    This prevents the NullPointerException.
        if (userRole == null) {
            System.out.println("ROLE_USER not found, creating it...");
            userRole = new Role();
            userRole.setName("ROLE_USER");
            roleRepository.save(userRole);
        }

        // 5. Assign the role to the user.
        user.setRoles(Collections.singleton(userRole));

        // 6. Save the fully prepared User object to the database.
        userRepository.save(user);

        System.out.println("Successfully registered user: " + user.getEmail());
    }
}