package com.example.sweater.repositories;


import com.example.sweater.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRep extends MongoRepository<User,String> {

    Optional<User> findUserByEmail(String email);
}
