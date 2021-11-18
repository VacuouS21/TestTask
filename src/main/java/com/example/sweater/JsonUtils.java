package com.example.sweater;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

public class JsonUtils {

    private static final String My_URL="https://watchlater.cloud.technokratos.com/search/film?query=";

    public static String normalUrl(String nameFilm) throws UnsupportedEncodingException {
        nameFilm= URLEncoder.encode(nameFilm, "utf-8");
        return My_URL+nameFilm;
    }
    public static String overReturn(String film, String data) throws UnsupportedEncodingException {
        URL url = JsonUtils.createUrl(normalUrl(film));

        // загружаем Json в виде Java строки
        String resultJson = JsonUtils.parseUrl(url);
        //System.out.println("Полученный JSON:\n" + resultJson);

        // парсим полученный JSON и печатаем его на экран
       return JsonUtils.parseCurrentJson(resultJson,film,data);
    }
    public static String parseUrl(URL url) {
        if (url == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        // открываем соедиение к указанному URL
        // помощью конструкции try-with-resources
        try (BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()))) {

            String inputLine;
            // построчно считываем результат в объект StringBuilder
            while ((inputLine = in.readLine()) != null) {
                stringBuilder.append(inputLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }



    public static String parseCurrentJson(String resultJson, String nameFilm, String dataRelease) {
        try {
            nameFilm=nameFilm.replaceAll(" ","");
            // конвертируем строку с Json в JSONObject для дальнейшего его парсинга
            JSONObject mainJsonObject = (JSONObject) JSONValue.parseWithException(resultJson);

            String over=" We can't find this film";

            JSONArray resultsArray = (JSONArray) mainJsonObject.get("results");
            for(int i = 0; i<resultsArray.size(); i++){

                //Заносим данные результатов поиска
                JSONObject bufResultsI= (JSONObject) resultsArray.get(i);

                String originalTitle= bufResultsI.get("originalTitle").toString().replaceAll(" ","");
                String title=bufResultsI.get("title").toString().replaceAll(" ","");
                //String data=bufResultsI.get("releaseDate").toString();
                //Фильм при нахождении
                if(nameFilm.equals(originalTitle) || nameFilm.equals(title)){
                    over=bufResultsI.get("overview").toString();
                    if(over.equals("")) over="We find film but film haven't description";
                    if(bufResultsI.get("releaseDate").toString().equals(dataRelease)){
                        break;
                    }
                }


            }

            return over;
        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
            return "ERROR";
        }

    }


    // создаем объект URL из указанной в параметре строки
    public static URL createUrl(String link) {
        try {
            return new URL(link);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }
}