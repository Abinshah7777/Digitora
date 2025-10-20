package com.agency.digital_agency.model;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ContactInquiry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String subject;

    @Lob
    @Column(columnDefinition="TEXT")
    private String message;

    // Automatically set the timestamp when the inquiry is first saved
    @Column(nullable = false, updatable = false)
    private LocalDateTime submissionDate;

    @PrePersist // This JPA annotation runs the method before saving
    protected void onCreate() {
        this.submissionDate = LocalDateTime.now();
    }

    public void setUsername(String name2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setUsername'");
    }
}