package com.java_basic.designpatterns.behavior_patterns.mediator;

import java.time.LocalDateTime;

public class FrontDesk {

    private CleaningService cleaningService = new CleaningService();
    private Restaurant restaurant = new Restaurant();

    public void getTowers(Guest guest,int numberOfTower) {
        cleaningService.getTower(guest.getId(),numberOfTower);
    }

    public void dinner(Guest guest, LocalDateTime dinnerTime) {
        restaurant.dinner(guest.getId(),dinnerTime);
    }
    public String getRoomNumber(Long guestId) {
        return "roomNumber";
    }
}
