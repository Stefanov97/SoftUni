package repositories;

import domain.entities.Car;

import java.util.List;

public interface CarRepository {
    void createCar(Car car, String username);
    List<Car> getAllCars();
}
