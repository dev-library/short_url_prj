package com.example.shorturl.repository;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ShortUrlRepositoryTests {
    private final Logger log = LoggerFactory.getLogger(getClass());
    @Autowired
    IShortUrlRepository shortUrlRepository;

    @Test
    public void test(){

    }
}
