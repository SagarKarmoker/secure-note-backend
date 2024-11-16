package com.sagar.secure_note_backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HelloController {

    @GetMapping("/hello")
    public String welcome() {
       return "Welcome to Secure Note Backend";
    }
}
