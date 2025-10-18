package com.agency.digital_agency.controller;

import com.agency.digital_agency.model.ContactInquiry;
import com.agency.digital_agency.service.ContactInquiryService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/contact")
public class ContactInquiryController {

    private final ContactInquiryService contactInquiryService;

    public ContactInquiryController(ContactInquiryService contactInquiryService) {
        this.contactInquiryService = contactInquiryService;
    }

    // Handles HTTP POST requests to /api/contact
    @PostMapping
    public ContactInquiry submitInquiry(@RequestBody ContactInquiry inquiry) {
        return contactInquiryService.saveInquiry(inquiry);
    }
}