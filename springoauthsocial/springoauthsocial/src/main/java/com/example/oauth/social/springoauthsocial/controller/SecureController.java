package com.example.oauth.social.springoauthsocial.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecureController {

    @GetMapping("/secure")
    public String  getSecurePage(){
        return "secure.html";
    }
}
