package com.basic.java.designpatterns.behavior_patterns.mediator;

public class CleaningService {

    private FrontDesk frontDesk = new FrontDesk();
    public void clean(Gym gym) {
        System.out.println("clean " + gym);
    }

    public void getTower(Long guestId, int numberOfTower) {
        String roomNumber = this.frontDesk.getRoomNumber(guestId);
        System.out.println("provide" + numberOfTower + "towers for " + roomNumber);
    }

    public void clean(Restaurant restaurant) {
        System.out.println("clean " + restaurant);
    }
}
