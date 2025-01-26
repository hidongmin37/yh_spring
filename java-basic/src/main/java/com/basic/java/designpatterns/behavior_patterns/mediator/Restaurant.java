package com.basic.java.designpatterns.behavior_patterns.mediator;

import java.time.LocalDateTime;

public class Restaurant {

    private CleaningService cleaningService = new CleaningService();

    public void dinner(Long guestId, LocalDateTime dinnerTime) {
        System.out.println("provide dinner for " + guestId + " at " + dinnerTime);
    }

    public void clean() {
        cleaningService.clean(this);
    }
}
