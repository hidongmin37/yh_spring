package com.basic.java.designpatterns.behavior_patterns.mediator;

public class Hotel {

    public static void main(String[] args) {
        Guest guest = new Guest();

        Restaurant restaurant = new Restaurant();
        restaurant.clean();
    }
}
