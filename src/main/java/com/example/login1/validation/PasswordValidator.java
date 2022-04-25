package com.example.login1.validation;

import org.springframework.stereotype.Component;

import javax.validation.Validator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class PasswordValidator {

    public boolean isValidPassword(String password)
    {

        String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,20}$";

        Pattern p = Pattern.compile(regex);

        if (password == null) {
            return false;
        }

        Matcher m = p.matcher(password);

        return m.matches();
    }
}
