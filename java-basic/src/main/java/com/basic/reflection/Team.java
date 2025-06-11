package com.basic.reflection;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@Setter
public class Team {
    private String id;
    private String name;

    public Team() {
    }
    public Team(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
