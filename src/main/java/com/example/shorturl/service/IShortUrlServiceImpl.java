package com.example.shorturl.service;

import com.example.shorturl.repository.IShortUrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IShortUrlServiceImpl implements IShortUrlService {
    @Autowired
    IShortUrlRepository shortUrlRepository;

    static int lastSavedIndex = 0;

    @Override
    public String getBase62(int index) {
        String result = "";

        while(index % 62 > 0 || result == "") {
            result += BASE62CHARLIST[index % 62];
            index = (int) (index / 62)
        }
        return result;
    }

    @Override
    public String getShortUrl() {
        return null;
    }
}
