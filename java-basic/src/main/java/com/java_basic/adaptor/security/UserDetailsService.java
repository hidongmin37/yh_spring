package com.java_basic.adaptor.security;

public interface UserDetailsService {

    UserDetails loadUser(String username);

}
