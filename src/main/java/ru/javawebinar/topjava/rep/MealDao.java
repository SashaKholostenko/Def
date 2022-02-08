package ru.javawebinar.topjava.rep;

import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.util.List;

public class MealDao implements MealRepository {
    private DataSource dataSource = DataSource.getInstance();

    @Override
    public Meal getById(int id) {
        return dataSource.getById(id);
    }

    @Override
    public Meal createOrUpdate(Meal meal) {
        return dataSource.createOrUpdate(meal);
    }

    @Override
    public Meal delete(int id) {
        return dataSource.delete(id);
    }

    @Override
    public List<Meal> getAll() {
        return dataSource.getAllMeals();
    }
}
