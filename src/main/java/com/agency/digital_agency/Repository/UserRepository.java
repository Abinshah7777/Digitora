package com.agency.digital_agency.Repository;

import com.agency.digital_agency.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // This method is for finding a user by their email (e.g., for registration checks)
    User findByEmail(String email);

    // ✅ ADD THIS NEW METHOD for logging in by username
    User findByUsername(String username);
}