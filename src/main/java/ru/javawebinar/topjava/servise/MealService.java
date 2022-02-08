package ru.javawebinar.topjava.servise;


import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealTo;

import java.time.LocalDateTime;
import java.util.List;

public interface MealService {

    Meal getById(int mealId);
    Meal createOrUpdate(Meal meal);
    Meal delete(int id);
    List<Meal> getAll();
    List<MealTo> getAllMealTo();
}
