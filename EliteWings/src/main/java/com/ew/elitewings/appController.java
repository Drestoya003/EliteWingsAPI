package com.ew.elitewings;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


public class appController {
    @RequestMapping("/")
    public String home() {
        return "home.html";
    }
}
