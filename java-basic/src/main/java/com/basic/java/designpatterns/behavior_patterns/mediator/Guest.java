package com.basic.java.designpatterns.behavior_patterns.mediator;

import java.time.LocalDateTime;

public class Guest {

    private Long id;

    private FrontDesk frontDesk = new FrontDesk();

    public void getTowers(int numberOfTower) {
        frontDesk.getTowers(this,numberOfTower);
    }

    private void dinner(LocalDateTime dinnerTime) {
        this.frontDesk.dinner(this,dinnerTime);

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
