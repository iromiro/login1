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
import java.util.List;

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

    @GetMapping("/userList")
    public ResponseEntity<List<User>> getUserList(){
        List<User> allUsers = userService.getUserList();
        return new ResponseEntity<List<User>>(allUsers, HttpStatus.OK);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<Boolean> login(@RequestBody User user) {
        //check login user exists and password valid
        Boolean login = userService.login(user.getPassword(), user.getUsername());
        return new ResponseEntity<Boolean>(login, HttpStatus.OK);
    }

}
