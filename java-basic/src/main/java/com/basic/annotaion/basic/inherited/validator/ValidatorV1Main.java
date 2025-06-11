package com.basic.annotaion.basic.inherited.validator;

import lombok.extern.slf4j.Slf4j;

import static com.basic.java.thread.util.MyLogger.log;

@Slf4j
public class ValidatorV1Main {
    public static void main(String[] args) {
        User user1 = new User("", 0);
        Team team1 = new Team("team1", 0);

        try {
            log("== user 검증 ==");
            validate(user1);
        } catch (Exception e) {
            log(e);
        }
        try {
            log("== team 검증 ==");
            validate(team1);
        } catch (Exception e) {
            log(e);
        }
    }

    private static void validate(User user) {
        if (user.getName() == null || user.getName().isEmpty()) {
            throw new RuntimeException("name은 필수입니다.");
        }
        if (user.getAge() > 100 || user.getAge() < 1) {
            throw new RuntimeException("age는 1 이상 100 이하이어야 합니다.");
        }
    }

    private static void validate(Team team) {
        if (team.getName() == null || team.getName().isEmpty()) {
            throw new RuntimeException("name은 필수입니다.");
        }
        if (team.getMemberCount() > 999 || team.getMemberCount() < 1) {
            throw new RuntimeException("memberCount는 1 이상 100 이하이어야 합니다.");
        }
    }
}
