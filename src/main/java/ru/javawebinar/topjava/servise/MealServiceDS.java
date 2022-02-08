package ru.javawebinar.topjava.servise;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealTo;
import ru.javawebinar.topjava.rep.MealRepository;
import ru.javawebinar.topjava.util.MealsUtil;

import java.util.List;

public class MealServiceDS implements MealService {
    private MealRepository repository;

    public MealServiceDS(MealRepository repository) {
        this.repository = repository;
    }

    @Override
    public Meal getById(int id) {
        return repository.getById(id);
    }

    @Override
    public Meal createOrUpdate(Meal meal) {

        return repository.createOrUpdate(meal);
    }

    @Override
    public Meal delete(int id) {

        return repository.delete(id);
    }

    @Override
    public List<Meal> getAll() {


        return repository.getAll();
    }

    @Override
    public List<MealTo> getAllMealTo() {


        return MealsUtil.filteredByStreams(repository.getAll(),
                null,
                null,
                MealsUtil.coloriesPerDay);
    }
}
