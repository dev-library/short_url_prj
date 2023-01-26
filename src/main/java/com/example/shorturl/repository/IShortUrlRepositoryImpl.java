package com.example.shorturl.repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class IShortUrlRepositoryImpl implements IShortUrlRepository{

    ArrayList<String> urlMappingList;

}
