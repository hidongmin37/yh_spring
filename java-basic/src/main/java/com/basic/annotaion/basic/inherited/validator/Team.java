package com.basic.annotaion.basic.inherited.validator;

public class Team {

    @NotEmpty(message = "팀 이름은 비어있을 수 없습니다.")
    private String name;

    @Range(min = 1, max = 999, message = "팀원 수는 1에서 999 사이여야 합니다.")
    private int memberCount;

    public Team(String name, int memberCount) {
        this.name = name;
        this.memberCount = memberCount;
    }

    public String getName() {
        return name;
    }

    public int getMemberCount() {
        return memberCount;
    }
}
