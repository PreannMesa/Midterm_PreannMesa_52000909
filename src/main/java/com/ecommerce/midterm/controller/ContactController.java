package com.ecommerce.midterm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class ContactController {
    @GetMapping("")
    public String showContactpage(){
        return "contact";
    }
}
