package com.java_basic.designpatterns.behavior_patterns.mediator;

public class Gym {

    private CleaningService cleaningService;

    public void clean() {
        cleaningService.clean(this);
    }
}
