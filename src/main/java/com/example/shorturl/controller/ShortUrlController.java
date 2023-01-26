package com.example.shorturl.controller;

import com.example.shorturl.service.IShortUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ShortUrlController {
    @Autowired
    IShortUrlService shortUrlservice;

    @GetMapping("/main")
    public String goMainPage(){
        return "main";
    }

    // 추후 짧은 URL 처리용으로 일단 대기
    @ResponseBody
    @GetMapping("/{longUrl}")
    public String sendRedirectLongUrl(@PathVariable String longUrl){
        return longUrl;
    }

    @ResponseBody
    @PostMapping("/url")
    public String getShortUrl(String longUrl){

    }



}
