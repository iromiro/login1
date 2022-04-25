package com.example.login1.webconfig;

import com.example.login1.ApiResponse;
import com.example.login1.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path="/api")
public class SignupResource {

    @PostMapping(value = "/registration")
    public ResponseEntity<ApiResponse> registration(@Valid @RequestBody User user) {

        return new ResponseEntity<>(
                new ApiResponse(user, "success", false), HttpStatus.OK);

    }
}
