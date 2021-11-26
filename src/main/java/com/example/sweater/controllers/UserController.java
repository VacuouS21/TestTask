package com.example.sweater.controllers;




import com.example.sweater.models.UserUpdateRequesModel;
import com.example.sweater.entity.User;
import com.example.sweater.repositories.UserRep;
import com.example.sweater.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserRep userRep;

    @Autowired
    UserService userService;

    @PostMapping("/user")
    public User createUser(@RequestBody User user){
        return userService.save(user);
    }

    @GetMapping("/user")
    List<User> getUsers(){
        return userService.getUsers();

    }
    @GetMapping("/user/{id}")
    User getUserFromId(@PathVariable String id){
        return userService.getUserFromId(id);
    }

    @PutMapping("/user/{id}")
    public User updateUser(@PathVariable String id, @Valid @RequestBody UserUpdateRequesModel userUpdateRequesModel) throws UnsupportedEncodingException {
        User user=userService.update(id,userUpdateRequesModel);
        return user;
    }

    @DeleteMapping("/user/{id}")
    public User deleteUser(@PathVariable String id){
        User status=userService.delete(id);
        return status;
    }
}
