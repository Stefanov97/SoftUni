package services;

import domain.models.service.CarServiceModel;

import java.util.List;

public interface CarService {
    void createCar(CarServiceModel car, String username) throws IllegalAccessException;
    List<CarServiceModel> getAllCars();
}
