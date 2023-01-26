package com.example.shorturl.service;

import org.springframework.stereotype.Service;

@Service
public class IShortUrlServiceImpl implements IShortUrlService {

    static int lastSavedIndex = 0;

    @Override
    public String getBase62() {
        return null;
    }

    @Override
    public String getShortUrl() {
        return null;
    }
}
