package com.agency.digital_agency.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PortfolioItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Lob
    @Column(columnDefinition="TEXT")
    private String description;

    private String imageUrl;
    private String projectLink;

    // --- This is the relationship mapping ---
    @ManyToOne // Defines a many-to-one relationship
    @JoinColumn(name = "category_id") // Specifies the foreign key column in this table
    private Category category;
}