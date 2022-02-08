package ru.javawebinar.topjava.controller;

import ru.javawebinar.topjava.service.MealService;
import ru.javawebinar.topjava.web.MealServlet;

public class MealController {
    private MealService mealService;

    public MealController(MealService mealService) {
        this.mealService = mealService;
    }
