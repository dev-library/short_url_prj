package com.example.shorturl.repository;

public interface IShortUrlRepository {

    boolean insertUrl(String longUrl);
    String getLongUrl(int longUrlIndex);

}
