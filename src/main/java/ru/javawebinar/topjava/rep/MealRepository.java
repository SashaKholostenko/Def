package ru.javawebinar.topjava.rep;

import ru.javawebinar.topjava.model.Meal;

import java.util.List;

public interface MealRepository {
    Meal getById(int mealId);
    Meal createOrUpdate(Meal meal);
    Meal delete(int id);
    List<Meal> getAll();
}
