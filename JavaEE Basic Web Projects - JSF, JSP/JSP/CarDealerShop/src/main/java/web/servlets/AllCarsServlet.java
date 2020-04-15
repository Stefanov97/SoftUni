package web.servlets;

import domain.models.service.CarServiceModel;
import domain.models.view.CarViewModel;
import org.modelmapper.ModelMapper;
import services.CarService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/cars/all")
public class AllCarsServlet extends HttpServlet {
    private final CarService carService;
    private final ModelMapper mapper;

    @Inject
    public AllCarsServlet(CarService carService, ModelMapper mapper){
        this.carService = carService;
        this.mapper = mapper;
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<CarServiceModel> cars = carService.getAllCars();
        req.setAttribute("viewModel",cars.stream().map(c -> this.mapper.map(c, CarViewModel.class)).collect(Collectors.toList()));
        req.getRequestDispatcher("/cars-all.jsp").forward(req,resp);
    }

}
