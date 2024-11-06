package com.java_basic.adaptor;

public class App {

    public static void main(String[] args) {
        AccountService accountService = new AccountService();
        AccountUserDetailsService accountUserDetailsService = new AccountUserDetailsService(accountService);
        LoginHandler loginHandler = new LoginHandler(accountUserDetailsService);
        String login = loginHandler.login("admin", "admin");
        System.out.println(login);
    }
}
