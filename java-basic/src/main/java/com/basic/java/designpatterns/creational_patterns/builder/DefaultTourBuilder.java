package com.basic.java.designpatterns.creational_patterns.builder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DefaultTourBuilder implements TourPlanBuilder{

    private String title;

    private int nights;

    private int days;

    private LocalDate startDate;

    private String whereToStay;

    private List<DetailPlan> detailPlans;

    @Override
    public TourPlanBuilder nightsAndDays(int nights, int days) {
        this.nights = nights;
        this.days = days;
        return this;
    }

    @Override
    public TourPlanBuilder title(String title) {
        this.title = title;
        return this;
    }


    @Override
    public TourPlanBuilder startDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    @Override
    public TourPlanBuilder whereToStay(String whereToStay) {
        this.whereToStay = whereToStay;
        return this;
    }

    @Override
    public TourPlanBuilder addPlan(int day, String plan) {
        if (this.detailPlans == null) {
            this.detailPlans = new ArrayList<>();
        } else {
            this.detailPlans.add(new DetailPlan(day, plan));
        }
        return this;
    }

    @Override
    public TourPlan getTourPlan() {
        return new TourPlan(title, nights, days, startDate, whereToStay, detailPlans);
    }
}
