package com.agency.digital_agency.controller;

import com.agency.digital_agency.model.ContactInquiry;
import com.agency.digital_agency.service.ContactInquiryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/contact")
public class ContactInquiryController {

    private final ContactInquiryService contactInquiryService;

    public ContactInquiryController(ContactInquiryService contactInquiryService) {
        this.contactInquiryService = contactInquiryService;
    }

    // Handles HTTP POST requests to /api/contact
    @PostMapping
    public ResponseEntity<?> submitInquiry(@RequestBody ContactInquiry inquiry, Principal principal) {
        // Check if user is logged in
        if (principal == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("You must be logged in to submit a contact inquiry.");
        }

        // Capture logged-in username
        inquiry.setUsername(principal.getName());

        ContactInquiry savedInquiry = contactInquiryService.saveInquiry(inquiry);
        return ResponseEntity.ok(savedInquiry);
    }
}
