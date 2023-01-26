package com.example.shorturl.controller;

import com.example.shorturl.service.IShortUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    // 추후 짧은 URL 처리용으로 일단 대기
    @ResponseBody
    @GetMapping("/{shortUrl}")
    public String sendRedirectLongUrl(@PathVariable String shortUrl){
        // 먼저 해당 shortUrl을 숫자로 디코딩
        //int index = shortUrlservice.getDecodeBase62(shortUrl);

        // 디코딩한 url을 인덱스를 이용해 뽑아오기
        // 주의할점은 서비스를 통해서 요청...?
        //String longUrl = shortUrlservice.getLongUrl(index);

        return "redirect:/" + "originalUrl";
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
