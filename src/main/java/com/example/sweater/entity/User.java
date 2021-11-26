package com.example.sweater.entity;

import com.example.sweater.services.FindFilm;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.UnsupportedEncodingException;

@Data
@Document
public class User {
    @Id
    private String id;

    private String fio;

    @Indexed(unique = true)
    private String email;

    private String aboutMe;

    private String hardSkill;

    private String workExperience;

    private String hobby;

    private String film;

    private String filmDescribtion;



    public User(String fio, String email, String aboutMe, String hardSkill, String workExperience, String hobby,String film) throws UnsupportedEncodingException {
        this.fio = fio;
        this.email = email;
        this.aboutMe = aboutMe;
        this.hardSkill = hardSkill;
        this.workExperience = workExperience;
        this.hobby = hobby;
        this.film=film;

        this.filmDescribtion= FindFilm.FindFilmDescribtion(film);
    }

}
