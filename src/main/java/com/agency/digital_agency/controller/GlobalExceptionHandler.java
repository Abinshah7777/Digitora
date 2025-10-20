package com.agency.digital_agency.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception ex) {
        System.out.println("=== GLOBAL EXCEPTION HANDLER ===");
        System.out.println("Exception Type: " + ex.getClass().getName());
        System.out.println("Exception Message: " + ex.getMessage());
        ex.printStackTrace();
        
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error");
        modelAndView.addObject("error", ex.getMessage());
        modelAndView.addObject("exception", ex);
        return modelAndView;
    }
}