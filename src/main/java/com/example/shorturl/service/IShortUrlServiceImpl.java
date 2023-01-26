package com.example.shorturl.service;

import com.example.shorturl.repository.IShortUrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IShortUrlServiceImpl implements IShortUrlService {
    @Autowired
    IShortUrlRepository shortUrlRepository;

    // 저장할번호 -1을 항상 가지는 변수. 저장할때마다 +1을 한다.
    static int lastSavedIndex = -1;

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
    public String getShortUrl(String longUrl) {
        String shortUrl = "";
        // 먼저 DB에 처 집어넣기 위해 라스트 인덱스 번호를 +1
        lastSavedIndex += 1;
        // 그 다음 해당 DB에 처집어넣기.
        shortUrlRepository.insertUrl(longUrl);

        // 집어넣은 url을 인코딩해서 저장받기
        shortUrl = getBase62(lastSavedIndex);

        return shortUrl;
    }
}
