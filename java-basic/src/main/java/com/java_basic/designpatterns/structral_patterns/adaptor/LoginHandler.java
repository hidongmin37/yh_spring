package com.java_basic.designpatterns.structral_patterns.adaptor;

import com.java_basic.designpatterns.structral_patterns.adaptor.security.UserDetails;
import com.java_basic.designpatterns.structral_patterns.adaptor.security.UserDetailsService;

public class LoginHandler {

    UserDetailsService userDetailsService;

    public LoginHandler(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    public String login(String username, String password) {
        UserDetails userDetails = userDetailsService.loadUser(username);
        if (userDetails.getPassword().equals(password)) {
            return userDetails.getUsername();
        } else {
            throw new IllegalArgumentException();
        }
    }
}
