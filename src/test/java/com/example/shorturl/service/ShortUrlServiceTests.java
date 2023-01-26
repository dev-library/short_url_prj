package com.example.shorturl.service;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ShortUrlServiceTests {
    private final Logger log = LoggerFactory.getLogger(getClass())
    @Autowired
    IShortUrlService shortUrlService;

    @Test
    public void test(){

    }

}
