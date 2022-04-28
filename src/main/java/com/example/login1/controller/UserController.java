package com.example.login1.controller;

import com.example.login1.exception.ValidationHandler;
import com.example.login1.model.User;
import com.example.login1.repository.UserRepository;
import com.example.login1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    ValidationHandler validation;
    @Autowired
    UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<User> register(@Valid @RequestBody User user){
        User registeredUser = userService.saveUser(user);
        return new ResponseEntity<User>(registeredUser, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public boolean login(@Valid @RequestBody String password, String username){
        return userRepository.findByUsername(username) != null;
    }


    //@RequestMapping(value = "/login", method = RequestMethod.POST)
    //public boolean login(String password, String username) {
        //check login user exists and password valid
      //  User user = new User(password, username);
        //if(username != null && password !=null){
          //  userService.login(password, username);
        //}
        //return false;
    //}

}
