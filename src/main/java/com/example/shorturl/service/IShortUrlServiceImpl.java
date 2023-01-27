package com.example.shorturl.service;

import com.example.shorturl.repository.IShortUrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class IShortUrlServiceImpl implements IShortUrlService {

    IShortUrlRepository shortUrlRepository;

    @Autowired
    IShortUrlServiceImpl(IShortUrlRepository shortUrlRepository){
        this.shortUrlRepository = shortUrlRepository;
    }

    // 저장할번호 0을 가지는 변수. 저장할때마다 +1을 한다.
    static int lastSavedIndex = 0;

    @Override
    public String getEncodeBase62(int index) {
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

        longUrl = checkPrefix(longUrl);
        // checkup부터 해서 검사
        int checkedIndex = shortUrlRepository.checkDuplication(longUrl);
        if(checkedIndex == -1){
            // 중복이 아닌 경우
            // 먼저 DB에 처 집어넣기 위해 라스트 인덱스 번호를 +1
            // 테스트할때는 몇백단위로 증가하게 해서 변하는거 확인함.
            // 이거 처음에 int였는데 long으로 하는게 좋을듯
            // long으로 하니까 인덱싱이 안됨 일단 int 유지
            lastSavedIndex += 1;

            // 그 다음 해당 DB에 처집어넣기.
            shortUrlRepository.insertUrl(longUrl);
            // 집어넣은 url을 인코딩해서 저장받기
            shortUrl = getEncodeBase62(lastSavedIndex);
        }else {
            // 중복인 경우
            shortUrl = getEncodeBase62(checkedIndex + 1);
        }
        return shortUrl;

    }

    @Override
    public int getDecodeBase62(String shortUrl) {
        // 디코드 로직
        int num = 0;
        int pow = 1;// 62의 승수

        for(int i = 0; i < shortUrl.length(); i++){
            // 배열에서 하나하나...
            num += BASE62CHARLIST.indexOf(shortUrl.charAt(i)) * pow;
            pow *= BASE62CHARLIST.length();
        }
        return num;
    }

    @Override
    public String getLongUrl(String shortUrl) {
        int longUrlIndex = getDecodeBase62(shortUrl);
        // 0번 인덱스 자료는 이상하게 리다이렉트가 안됨. 사용자에겐 0이 아닌 1부터 주지만, 실제로는 -1해서 논리적으로는 입력순서에 맞게 0부터 조회하도록
        return shortUrlRepository.getLongUrl(longUrlIndex-1);
    }

    @Override
    public String checkPrefix(String longUrl) {
        Pattern pattern = Pattern.compile("http" + ".*");
        Matcher matcher = pattern.matcher(longUrl);
        if(!matcher.find()){
            longUrl = "http://" + longUrl;
        }
        return longUrl;
    }

    @Override
    public boolean checkPattern(String longUrl) {
        Pattern pattern = Pattern.compile(".*\\..*");
        Matcher matcher = pattern.matcher(longUrl);

        return matcher.find();
    }


}
