package com.basic.java.designpatterns.structral_patterns.adaptor.security;

public interface UserDetailsService {

    UserDetails loadUser(String username);

}
