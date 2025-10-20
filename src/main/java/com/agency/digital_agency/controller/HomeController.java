package com.agency.digital_agency.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    public HomeController() {
        System.out.println("<<<<<<<<<< HomeController has been loaded and is active! >>>>>>>>>>");
    }

    @GetMapping("/")
    public String homePage() {
        System.out.println(">>>>>>>>>>>>>> / URL (Homepage) was called. THIS IS WORKING. >>>>>>>>>>>>>>");
        return "index";
    }

    @GetMapping("/services")
    public String servicesPage() {
        System.out.println("!!!!!!!!!!!!!!!!!! /services URL WAS CALLED AND THIS METHOD IS RUNNING !!!!!!!!!!!!!!!!!!");
        return "services";
    }

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

    // Project Case Study Pages
    @GetMapping("/project/ecommerce")
    public String ecommerceProject() {
        System.out.println(">>>>>> E-commerce Project Page Called");
        try {
            return "projects/ecommerce";
        } catch (Exception e) {
            System.out.println("Error loading ecommerce project: " + e.getMessage());
            e.printStackTrace();
            return "error";
        }
    }

    @GetMapping("/project/fitlife")
    public String fitlifeProject() {
        System.out.println(">>>>>> FitLife Project Page Called");
        try {
            return "projects/fitlife";
        } catch (Exception e) {
            System.out.println("Error loading fitlife project: " + e.getMessage());
            e.printStackTrace();
            return "error";
        }
    }

    @GetMapping("/project/innovate")
    public String innovateProject() {
        System.out.println(">>>>>> Innovate Corp Project Page Called");
        try {
            return "projects/innovate";
        } catch (Exception e) {
            System.out.println("Error loading innovate project: " + e.getMessage());
            e.printStackTrace();
            return "error";
        }
    }

    @GetMapping("/project/quantum")
    public String quantumProject() {
        System.out.println(">>>>>> Quantum Analytics Project Page Called");
        try {
            return "projects/quantum";
        } catch (Exception e) {
            System.out.println("Error loading quantum project: " + e.getMessage());
            e.printStackTrace();
            return "error";
        }
    }
}