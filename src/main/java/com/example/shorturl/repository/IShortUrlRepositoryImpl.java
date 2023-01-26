package com.example.shorturl.repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class IShortUrlRepositoryImpl implements IShortUrlRepository{

    static ArrayList<String> urlMappingList = new ArrayList<String>();

    @Override
    public boolean insertUrl(String longUrl) {

        urlMappingList.add(longUrl);
        // 추후 입력 실패시엔 false도 리턴하도록 개선 필요.
        return true;
    }

    @Override
    public String getLongUrl(int longUrlIndex) {
        return urlMappingList.get(longUrlIndex);
    }
}
