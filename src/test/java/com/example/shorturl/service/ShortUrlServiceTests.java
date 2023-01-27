package com.example.shorturl.service;

import com.example.shorturl.repository.IShortUrlRepository;
import com.example.shorturl.repository.IShortUrlRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ShortUrlServiceTests {
    private final Logger log = LoggerFactory.getLogger(getClass());
    @Autowired
    IShortUrlService shortUrlService;

    @Test
    public void checkPrefixTest(){
        log.info(shortUrlService.checkPrefix("https://www.naver.com"));
    }

    @Test
    public void checkGetShortUrl(){
        log.info(shortUrlService.getShortUrl("www.naver.com"));
    }

}
