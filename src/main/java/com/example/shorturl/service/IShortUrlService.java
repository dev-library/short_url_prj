package com.example.shorturl.service;

public interface IShortUrlService {

    final String BASE62CHARLIST = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";


    public String getEncodeBase62(int index);
    public String getShortUrl(String longUrl);
    public int getDecodeBase62(String shortUrl);
    public String getLongUrl(String shortUrl);
    public String checkPrefix(String longUrl);
    public boolean checkPattern(String longUrl);
}
