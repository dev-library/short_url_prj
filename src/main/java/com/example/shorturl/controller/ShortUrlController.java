package com.example.shorturl.controller;

import com.example.shorturl.service.IShortUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;


@Controller
public class ShortUrlController {

    IShortUrlService shortUrlservice;

    @Autowired
    ShortUrlController(IShortUrlService shortUrlService){
        this.shortUrlservice = shortUrlService;
    }

    @GetMapping("/main")
    public String goMainPage(){
        return "main";
    }

    // 이동은 잘 되나 https:// 가 안 붙는거 처리가 추가로 들어가야함
    @GetMapping("/{shortUrl}")
    public String sendRedirectLongUrl(@PathVariable String shortUrl){

        return "redirect:https://" + shortUrlservice.getLongUrl(shortUrl);
    }

    @ResponseBody
    @PostMapping("/encode")
    public String getShortUrl(String longUrl){
        // 긴 url을 받았다면 서비스에 저장로직을 호출
        String shortUrl = shortUrlservice.getShortUrl(longUrl);

        // 저장 완료되었음을 알려주는 페이지로 이동
        // shortUrl을 받아서 화면에 띄워주고 마무리
        return "shortUrl 결과 : " + shortUrl;
    }

}
