package com.example.sweater;


import com.example.sweater.models.User;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.List;

@AllArgsConstructor
@Service
public class UserService {
    @Autowired
    UserRep userRep;



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
        user.setAbout_me(userUpdateRequesModel.getAbout_me());
        user.setEmail(userUpdateRequesModel.getEmail());
        user.setHard_skill(userUpdateRequesModel.getHard_skill());
        user.setWork_experience(userUpdateRequesModel.getWork_experience());
        user.setHobby(userUpdateRequesModel.getHobby());
        user.setFilm(userUpdateRequesModel.getFilm());
        user.setDataRealese(userUpdateRequesModel.getDataRealese());
        user.setFilm_Describtion(JsonUtils.overReturn(userUpdateRequesModel.getFilm(),userUpdateRequesModel.getDataRealese()));
        userRep.save(user);
        return user;
    }

    public User getUserFromId(String id){
        return userRep.findById(id).orElse(null);
    }
    public String delete(String id) {
        userRep.deleteById(id);
        return id + " deleted";
    }
}
