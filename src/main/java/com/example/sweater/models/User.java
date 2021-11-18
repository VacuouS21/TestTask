package com.example.sweater.models;

import com.example.sweater.JsonUtils;
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

    private String about_me;

    private String hard_skill;

    private String work_experience;

    private String hobby;

    private String film;

    private String dataRealese;

    private String film_Describtion;



    public User(String fio, String email, String about_me, String hard_skill, String work_experience, String hobby,String film,String dataRealese) throws UnsupportedEncodingException {
        this.fio = fio;
        this.email = email;
        this.about_me = about_me;
        this.hard_skill = hard_skill;
        this.work_experience = work_experience;
        this.hobby = hobby;
        this.film=film;
        this.dataRealese=dataRealese;
        this.film_Describtion= JsonUtils.overReturn(film,dataRealese);
    }

}
