package com.example.sweater;

import com.example.sweater.entity.User;


import com.example.sweater.repositories.UserRep;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    @Bean
    CommandLineRunner runner (UserRep repositry){
        return args->{


            User user =new User(
                    "Kulagin Konstantin Vladimirovich",
                    "Vac@gmail.com",
                    "I'am student from KFU",
                    "I'm learning Java and Spring Core",
                    "I'm studying",
                    "bicycling, painting",
                    "Белоснежка"
            );
            repositry.findUserByEmail(user.getEmail())
                    .ifPresentOrElse(s->{
                System.out.println(s.getFio()+" already exist");
            },()->{
                System.out.println("Inserting "+user.getFio());
                repositry.insert(user);
            });
        };

    }
}


