package ru.javawebinar.topjava.controller;


import ru.javawebinar.topjava.servise.MealService;

public class MealController {
    private MealService mealService;

    public MealController(MealService mealService) {
        this.mealService = mealService;
    }
}
