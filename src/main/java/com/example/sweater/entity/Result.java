package com.example.sweater.entity;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
@Data
public class Result {
    public String posterPath;
    public String overview;
    public String releaseDate;
    public String originalTitle;
    public String originalLanguage;
    public String title;
    public String blackdropPath;
    public Long id;
    public int voteCount;
    public int[] genreIds;
    public int popularity;
    public int voteAverage;
    public boolean video;
    public boolean adult;












    /*
    *  {
      "adult": true,
      "backdropPath": "string",
      "genreIds": [
        0
      ],
      "id": 0,
      "originalLanguage": "string",
      "originalTitle": "string",
      "overview": "string",
      "popularity": 0,
      "posterPath": "string",
      "releaseDate": "string",
      "title": "string",
      "video": true,
      "voteAverage": 0,
      "voteCount": 0
    }*/
}
