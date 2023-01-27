package com.example.shorturl.repository;

import java.util.ArrayList;

public interface IShortUrlRepository {

    boolean insertUrl(String longUrl);
    String getLongUrl(int longUrlIndex);
    int checkDuplication(String longUrl);

}
