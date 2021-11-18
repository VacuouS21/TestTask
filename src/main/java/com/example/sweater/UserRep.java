package com.example.sweater;


import com.example.sweater.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRep extends MongoRepository<User,String> {

    Optional<User> findUserByEmail(String email);
}
