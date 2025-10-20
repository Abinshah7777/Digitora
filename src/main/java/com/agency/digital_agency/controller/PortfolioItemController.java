package com.agency.digital_agency.controller;

import com.agency.digital_agency.model.PortfolioItem;
import com.agency.digital_agency.service.PortfolioItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
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

    // NEW: Protected Submit Work endpoint
    @PostMapping
    public ResponseEntity<?> submitWork(@RequestBody PortfolioItem portfolioItem, Principal principal) {
        if (principal == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("You must be logged in to submit your work.");
        }

        // Capture logged-in username
        portfolioItem.setUsername(principal.getName());

        PortfolioItem savedItem = portfolioItemService.savePortfolioItem(portfolioItem);
        return ResponseEntity.ok(savedItem);
    }
}
