package com.example.shorturl.service;

public interface IShortUrlService {

    String BASE62CHARLIST = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";


    String getEncodeBase62(int index);
    public String getShortUrl(String longUrl);
    String getDecodeBase62(String shortUrl);
    public String getLongUrl(String shortUrl);
}
