package com.example.shorturl.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ShortUrlRepositoryTests {

    @Autowired
    IShortUrlRepository shortUrlRepository;

    @Test
    public void test(){

    }
}
