package web.servlets;

import domain.entities.Engine;
import domain.models.service.CarServiceModel;
import services.CarService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/cars/create")
public class CreateCarsServlet extends HttpServlet {
    private final CarService carService;

    @Inject
    public CreateCarsServlet(CarService carService) {
        this.carService = carService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/cars-create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String brand = req.getParameter("brand");
        String model = req.getParameter("model");
        String year = req.getParameter("year");
        String engineName = req.getParameter("engine");
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("user");
        CarServiceModel car = new CarServiceModel(brand,model,Integer.parseInt(year), Engine.valueOf(engineName.substring(0, 1).toUpperCase() + engineName.substring(1)));
        try {
            this.carService.createCar(car, username);
            resp.sendRedirect("/cars/all");
        } catch (IllegalAccessException e) {
            resp.sendRedirect("/cars/create");
        }


    }
}
