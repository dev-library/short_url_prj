package com.example.shorturl.controller;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ShortUrlController {

    @GetMapping("/main")
    public String goMainPage(){
        return "main";
    }

    @ResponseBody
    @GetMapping("/url/{id}")
    public String apiServer(@PathVariable String id){
        return "" + id;
    }

}
