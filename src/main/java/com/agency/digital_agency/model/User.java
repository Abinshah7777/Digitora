package com.agency.digital_agency.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

/**
 * Represents a User entity in the database.
 * This version uses a many-to-many relationship with a separate Role entity,
 * which is the standard and recommended approach for Spring Security.
 */
@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    /**
     * Defines the relationship between a User and their Roles.
     * - @ManyToMany: A user can have multiple roles (e.g., USER, ADMIN),
     *   and a role can be assigned to multiple users.
     * - fetch = FetchType.EAGER: This is crucial for security. It tells JPA to
     *   load the user's roles immediately when the user object is fetched.
     *   Spring Security needs this information right away to check permissions.
     * - @JoinTable: This annotation configures the special "join table" that
     *   links users and roles together in the database. It will create a table
     *   named 'users_roles' with two columns: 'user_id' and 'role_id'.
     */
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
        name = "users_roles",
        joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    private Set<Role> roles = new HashSet<>();

    // Default constructor
    public User() {}

}