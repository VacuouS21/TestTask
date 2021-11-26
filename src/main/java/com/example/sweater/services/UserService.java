package com.example.sweater.services;


import com.example.sweater.repositories.UserRep;
import com.example.sweater.models.UserUpdateRequesModel;
import com.example.sweater.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.List;

//@AllArgsConstructor
@Service
public class UserService {
   @Autowired
   UserRep userRep;


    public UserService(UserRep myRepository){
        this.userRep = myRepository;
    }

    public User save(User user){
        User newUser= userRep.save(user);
        return newUser;
    }
    public List<User> getUsers(){

        return userRep.findAll();
    }

    public User update(String id, UserUpdateRequesModel userUpdateRequesModel) throws UnsupportedEncodingException {

        User user=userRep.findById(id).orElseThrow();
        user.setFio(userUpdateRequesModel.getFio());
        user.setAboutMe(userUpdateRequesModel.getAboutMe());
        user.setEmail(userUpdateRequesModel.getEmail());
        user.setHardSkill(userUpdateRequesModel.getHardSkill());
        user.setWorkExperience(userUpdateRequesModel.getWorkExperience());
        user.setHobby(userUpdateRequesModel.getHobby());
        user.setFilm(userUpdateRequesModel.getFilm());

       user.setFilmDescribtion(FindFilm.FindFilmDescribtion(userUpdateRequesModel.getFilm()));
        userRep.save(user);
        return user;
    }

    public User getUserFromId(String id){
        return userRep.findById(id).orElse(null);
    }

    public User delete(String id) {
        User user = userRep.findById(id).orElse(null);
        if(user!=null) userRep.deleteById(id);
        return user;
    }
}
