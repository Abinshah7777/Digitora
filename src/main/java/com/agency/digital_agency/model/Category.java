package com.agency.digital_agency.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity // Tells JPA that this class is mapped to a database table
@Getter   // Lombok annotation to automatically generate all getter methods
@Setter   // Lombok annotation to automatically generate all setter methods
public class Category {

    @Id // Marks this field as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Configures the ID to be auto-incremented by the database
    private Long id;

    private String name;
}