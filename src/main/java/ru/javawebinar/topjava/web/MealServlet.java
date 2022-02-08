package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.rep.MealDao;
import ru.javawebinar.topjava.rep.MealRepository;
import ru.javawebinar.topjava.servise.MealService;
import ru.javawebinar.topjava.servise.MealServiceDS;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

import static org.slf4j.LoggerFactory.getLogger;

public class MealServlet extends HttpServlet {
    private static final Logger log = getLogger(MealServlet.class);

    private MealService service;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("Meals doGet");
        req.setCharacterEncoding("UTF-8");

        if(req.getParameter("update") !=null){
            log.debug("update");

            Meal meal = service.getById(Integer.parseInt(req.getParameter("update")));

              /*  req.setAttribute("id",meal.getId());
                req.setAttribute("date",LocalDateTime.of(meal.getDate(),meal.getTime()));
                req.setAttribute("description",meal.getDescription());
                req.setAttribute("calories",meal.getCalories());*/
            req.setAttribute("m",meal);
        }


        req.setAttribute("meals", service.getAllMealTo());

        req.getRequestDispatcher("meals.jsp").forward(req, resp);

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("Meals doPost");
        req.setCharacterEncoding("UTF-8");

        if (req.getParameter("Save") != null) {
            Meal meal = new Meal(LocalDateTime.parse(req.getParameter("date")),
                    req.getParameter("description"),
                    Integer.parseInt(req.getParameter("calories")));

            if (!(req.getParameter("id").isEmpty())) {
                meal.setId(Integer.parseInt(req.getParameter("id")));
            }
            service.createOrUpdate(meal);
        }

        if (req.getParameter("delete") != null) {
            service.delete(Integer.parseInt(req.getParameter("delete")));
            log.debug(req.getParameter("delete") + " id delete");
        }


        req.setAttribute("meals", service.getAllMealTo());
        req.getRequestDispatcher("meals.jsp").forward(req, resp);

    }

    @Override
    public void init() throws ServletException {

        MealRepository repository = new MealDao();
        log.debug("new repository");
        this.service = new MealServiceDS(repository);
        log.debug("new service");
        super.init();

    }
}
