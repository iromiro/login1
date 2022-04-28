package com.example.login1.service;

import com.example.login1.repository.RoleRepository;
import com.example.login1.model.User;
import com.example.login1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User saveUser(User user) {
        user.setRoles(Arrays.asList(roleRepository.findByRole("USER")));
        user.setEnabled(true);
        return userRepository.save(user);
    }

    public List<User> getUserList(){
        return userRepository.findAll();
    }

    public boolean login(String password, String username) {

        User user = userRepository.findByUsername(username);
        if (user.getPassword().equals(password)) {
            System.out.println("Succesfully logged in");
            return true;
        } else {
            return false;
        }
    }
}
