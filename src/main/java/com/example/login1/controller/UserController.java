package com.example.login1.controller;

import com.example.login1.model.User;
import com.example.login1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController {

    @Autowired
    UserService userService;


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public boolean login(String password, String username) {
        //check login user exists and password valid
        User user = new User(username, password);
        userService.login(username, password);
        return false;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@Valid User user) {
        userService.saveUser(user);
        return "index";
    }


    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/secure")
    public String secure() {
        return "secure";
    }

}
