package services.impl;

import domain.entities.Car;
import domain.entities.Engine;
import domain.models.service.CarServiceModel;
import org.modelmapper.ModelMapper;
import repositories.CarRepository;
import services.CarService;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class CarServiceImpl implements CarService {


    private final CarRepository carRepository;
    private final ModelMapper mapper;


    @Inject
    public CarServiceImpl(CarRepository carRepository, ModelMapper mapper) {
        this.carRepository = carRepository;

        this.mapper = mapper;
    }

    @Override
    public void createCar(CarServiceModel car, String username) throws IllegalAccessException {
        if (car.getBrand().isEmpty() || car.getModel().isEmpty() || car.getYear() == null) {
            throw new IllegalAccessException();
        } else {
                this.carRepository.createCar(this.mapper.map(car,Car.class), username);
        }
    }

    @Override
    public List<CarServiceModel> getAllCars() {
        List<Car> cars = this.carRepository.getAllCars();
        return cars.stream().map(c-> this.mapper.map(c, CarServiceModel.class)).collect(Collectors.toList());
    }
}
