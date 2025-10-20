package com.agency.digital_agency.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    public HomeController() {
        System.out.println("<<<<<<<<<< HomeController has been loaded and is active! >>>>>>>>>>");
    }

    // THIS IS THE CONTROL TEST FOR A WORKING URL
    @GetMapping("/")
    public String homePage() {
        System.out.println(">>>>>>>>>>>>>> / URL (Homepage) was called. THIS IS WORKING. >>>>>>>>>>>>>>");
        return "index";
    }

    // THIS IS THE TEST FOR THE BROKEN URL
    @GetMapping("/services")
    public String servicesPage() {
        // IF YOU DO NOT SEE THIS MESSAGE IN THE CONSOLE, THE BUILD IS BROKEN.
        System.out.println("!!!!!!!!!!!!!!!!!! /services URL WAS CALLED AND THIS METHOD IS RUNNING !!!!!!!!!!!!!!!!!!");
        return "services";
    }

    // THE REST OF THE METHODS FOR COMPLETENESS
    @GetMapping("/portfolio")
    public String portfolioPage() {
        System.out.println("!!!!!!!!!!!!!!!!!! /portfolio URL WAS CALLED AND THIS METHOD IS RUNNING !!!!!!!!!!!!!!!!!!");
        return "portfolio";
    }

    @GetMapping("/contact")
    public String contactPage() {
        System.out.println("!!!!!!!!!!!!!!!!!! /contact URL WAS CALLED AND THIS METHOD IS RUNNING !!!!!!!!!!!!!!!!!!");
        return "contact";
    }
    
    @GetMapping("/about")
    public String aboutPage() {
        System.out.println("!!!!!!!!!!!!!!!!!! /about URL WAS CALLED AND THIS METHOD IS RUNNING !!!!!!!!!!!!!!!!!!");
        return "about";
    }
}