package com.basic.java.designpatterns.creational_patterns.builder;

public class TourDirector {

    private TourPlanBuilder tourPlanBuilder;

    public TourDirector(TourPlanBuilder tourPlanBuilder) {
        this.tourPlanBuilder = tourPlanBuilder;
    }

    public TourPlan cancunTour() {
        return tourPlanBuilder.title("Cancun Tour")
                .nightsAndDays(3, 4)
                .startDate(java.time.LocalDate.now())
                .whereToStay("cancun Hotel")
                .addPlan(1, "Visit the beach")
                .addPlan(2, "Visit the museum")
                .addPlan(3, "Visit the park")
                .getTourPlan();
    }

    public TourPlan seoulTour() {
        return tourPlanBuilder.title("Seoul Tour")
                .nightsAndDays(2, 3)
                .startDate(java.time.LocalDate.now())
                .whereToStay("seoul Hotel")
                .addPlan(1, "Visit the palace")
                .addPlan(2, "Visit the market")
                .addPlan(3, "Visit the park")
                .getTourPlan();
    }
}
