package com.mvc.common.util;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

public class AuthenticationUtils {

    public static PasswordEncoder getPasswordEnconer(){
        return new StandardPasswordEncoder("543212345");
    }
}
