package com.example.shorturl.service;

import com.example.shorturl.repository.IShortUrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class IShortUrlServiceImpl implements IShortUrlService {

    IShortUrlRepository shortUrlRepository;

    @Autowired
    IShortUrlServiceImpl(IShortUrlRepository shortUrlRepository){
        this.shortUrlRepository = shortUrlRepository;
    }

    // 저장할번호 -1을 항상 가지는 변수. 저장할때마다 +1을 한다.
    static int lastSavedIndex = -1;

    @Override
    String getEncodeBase62(int index) {
        String result = "";

        while(index % 62 > 0 || result == "") {
            result += BASE62CHARLIST.charAt(index % 62);
            index = (int) (index / 62);
        }
        return result;
    }

    @Override
    public String getShortUrl(String longUrl) {
        String shortUrl = "";
        // 먼저 DB에 처 집어넣기 위해 라스트 인덱스 번호를 +1
        // 테스트할때는 몇백단위로 증가하게 해서 변하는거 확인함.
        // 이거 처음에 int였는데 long으로 하는게 좋을듯
        // long으로 하니까 인덱싱이 안됨 일단 int 유지
        lastSavedIndex += 1;
        // 그 다음 해당 DB에 처집어넣기.
        boolean isInsertOk =  shortUrlRepository.insertUrl(longUrl);

        // 집어넣은 url을 인코딩해서 저장받기
        shortUrl = getEncodeBase62(lastSavedIndex);

        return shortUrl;
    }

    @Override
    String getDecodeBase62(String shortUrl) {
        // 디코드 로직
        int num = 0;
        int pow = 1;// 62의 승수

        for(int i = 0; i < shortUrl.length(); i++){
            // 배열에서 하나하나...
            num += BASE62CHARLIST.indexOf(shortUrl.charAt(i)) * pow;
            pow *= BASE62CHARLIST.length();
        }
        return "" + num;
    }

    @Override
    public String getLongUrl(String shortUrl) {



        return null;
    }


}
