package com.agency.digital_agency.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    // Your ER diagram specifies 'TEXT' which can be a long string.
    // @Lob combined with @Column(columnDefinition="TEXT") ensures it.
    @Lob
    @Column(columnDefinition="TEXT")
    private String description;

    private String iconUrl; // Changed from icon-url in diagram to camelCase
}