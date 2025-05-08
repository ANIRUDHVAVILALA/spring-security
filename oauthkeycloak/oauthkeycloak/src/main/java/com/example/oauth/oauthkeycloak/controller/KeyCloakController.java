package com.example.oauth.oauthkeycloak.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class KeyCloakController {

    @GetMapping("/hello")
    public String getHelloWorld(){
        return "helloworld";
    }

    @GetMapping("/demo")
    public String getResponse(){
        return "response";
    }


}
