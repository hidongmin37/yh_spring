package com.basic.java.designpatterns.behavior_patterns.mediator;

public class Gym {

    private CleaningService cleaningService;

    public void clean() {
        cleaningService.clean(this);
    }
}
