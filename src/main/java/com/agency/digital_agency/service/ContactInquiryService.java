package com.agency.digital_agency.service;

import com.agency.digital_agency.Repository.ContactInquiryRepository;
import com.agency.digital_agency.model.ContactInquiry;
import org.springframework.stereotype.Service;

@Service
public class ContactInquiryService {

    private final ContactInquiryRepository contactInquiryRepository;

    public ContactInquiryService(ContactInquiryRepository contactInquiryRepository) {
        this.contactInquiryRepository = contactInquiryRepository;
    }

    // This method saves the submitted inquiry to the database
    public ContactInquiry saveInquiry(ContactInquiry inquiry) {
        // Here you could add more logic in the future,
        // like sending an email notification.
        return contactInquiryRepository.save(inquiry);
    }
}