package com.agency.digital_agency.service;

import com.agency.digital_agency.Repository.PortfolioItemRepository;
import com.agency.digital_agency.model.PortfolioItem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortfolioItemService {

    private final PortfolioItemRepository portfolioItemRepository;

    public PortfolioItemService(PortfolioItemRepository portfolioItemRepository) {
        this.portfolioItemRepository = portfolioItemRepository;
    }

    public List<PortfolioItem> getAllPortfolioItems() {
        return portfolioItemRepository.findAll();
    }
}