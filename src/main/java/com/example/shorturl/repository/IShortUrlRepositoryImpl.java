package com.example.shorturl.repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class IShortUrlRepositoryImpl implements IShortUrlRepository{

    static ArrayList<String> urlMappingList = new ArrayList<>();

    @Override
    public boolean insertUrl(String longUrl) {

        // 검사부터 하자

        urlMappingList.add(longUrl);
        // 추후 입력 실패시엔 false도 리턴하도록 개선 필요.
        return true;
    }

    @Override
    public String getLongUrl(int longUrlIndex) {
        // IndexOutOfBoundsException 남. 자꾸 이상한 번호를 한 번 더 처집어넣는데 영문을 모르겠음
        // 루트주소 이외에 다른 주소를 소거해서 해결
        return urlMappingList.get(longUrlIndex);
    }

    @Override
    public int checkDuplication(String longUrl) {
        return urlMappingList.indexOf(longUrl);
    }



}
