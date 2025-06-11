package com.basic.annotaion.basic.inherited.validator;

import lombok.extern.slf4j.Slf4j;

import static com.basic.java.thread.util.MyLogger.log;

@Slf4j
public class ValidatorV2Main {
    public static void main(String[] args) {
        User user1 = new User("", 0);
        Team team1 = new Team("team1", 0);

        try {
            log("== user 검증 ==");
            Validator.validate(user1);
        } catch (Exception e) {
            log(e);
        }
        try {
            log("== team 검증 ==");
            Validator.validate(team1);
        } catch (Exception e) {
            log(e);
        }
    }

}
