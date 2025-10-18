package com.agency.digital_agency.controller;

import com.agency.digital_agency.model.PortfolioItem;
import com.agency.digital_agency.service.PortfolioItemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/portfolio")
public class PortfolioItemController {

    private final PortfolioItemService portfolioItemService;

    public PortfolioItemController(PortfolioItemService portfolioItemService) {
        this.portfolioItemService = portfolioItemService;
    }

    @GetMapping
    public List<PortfolioItem> getAllPortfolioItems() {
        return portfolioItemService.getAllPortfolioItems();
    }
}