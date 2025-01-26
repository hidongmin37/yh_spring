package com.basic.java.designpatterns.structral_patterns.adaptor;

import com.basic.java.designpatterns.structral_patterns.adaptor.security.UserDetails;
import com.basic.java.designpatterns.structral_patterns.adaptor.security.UserDetailsService;

public class AccountUserDetailsService implements UserDetailsService {

    private AccountService accountService;

    public AccountUserDetailsService(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public UserDetails loadUser(String username) {
        Account accountByUsername = accountService.findAccountByUsername(username);
        return new AccountUserDetails(accountByUsername);
    }
}
