package ru.javawebinar.topjava.rep;

import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class DataSource {
    private Map<Integer, Meal> mealMap = new ConcurrentHashMap();
    private static DataSource ourInstance = new DataSource();
    private AtomicInteger newid = new AtomicInteger(1);



    private DataSource() {

    }


    public static DataSource getInstance() {
        ourInstance.test();//test
        return ourInstance;
    }

    public Meal getById(int id){

        return mealMap.get(id);
    }
    public List<Meal> getAllMeals() {
        return Collections.unmodifiableList(new ArrayList<>(mealMap.values()));
    }

    public Meal createOrUpdate(Meal meal) {
        if (meal == null)
            return null;

        //new
        if (meal.getId() == 0)
            return create(meal);
        else
            return update(meal);
    }

    private Meal create(Meal newMeal) {
        newMeal.setId(newid.getAndIncrement());
        return mealMap.put(newMeal.getId(), newMeal);

    }

    private Meal update(Meal meal) {


        return mealMap.put(meal.getId(), meal);
    }

    public Meal delete(int id) {
        return mealMap.remove(id);
    }


    private   void test() {

        ourInstance.create(new Meal(LocalDateTime.of(2020, Month.JANUARY, 30, 10, 0), "Завтрак", 500));
        ourInstance.create(new Meal(LocalDateTime.of(2020, Month.JANUARY, 30, 13, 0), "Обед", 1000));
        ourInstance.create(new Meal(LocalDateTime.of(2020, Month.JANUARY, 30, 20, 0), "Ужин", 500));
        ourInstance.create(new Meal(LocalDateTime.of(2020, Month.JANUARY, 31, 0, 0), "Еда на граничное значение", 100));
        ourInstance.create(new Meal(LocalDateTime.of(2020, Month.JANUARY, 31, 10, 0), "Завтрак", 1000));
        ourInstance.create(new Meal(LocalDateTime.of(2020, Month.JANUARY, 31, 13, 0), "Обед", 500));
        ourInstance.create(new Meal(LocalDateTime.of(2020, Month.JANUARY, 31, 20, 0), "Ужин", 410));


    }
}
