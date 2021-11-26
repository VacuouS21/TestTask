package com.example.sweater.services;

import com.example.sweater.entity.Result;
import com.example.sweater.entity.Site;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;


public class FindFilm {
    static RestTemplate restTemplate=new RestTemplate();

    public static String FindFilmDescribtion(String filmName){
        String url="https://watchlater.cloud.technokratos.com/search/film?query=";
        String desribtion="";
        String normalUrl=url+filmName;

        Site response = restTemplate.getForObject(normalUrl,Site.class);
        List<Result> resultList=response.getResults();
        for(Result i:resultList){
            if(i.getOriginalTitle().equals(filmName) || i.getTitle().equals(filmName)){
                return i.getOverview();
            }
        }
        return "Can't find your film";
    }
}
