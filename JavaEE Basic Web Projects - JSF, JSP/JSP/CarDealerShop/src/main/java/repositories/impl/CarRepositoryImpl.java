package repositories.impl;

import domain.entities.Car;
import domain.entities.User;
import domain.models.service.CarServiceModel;
import org.modelmapper.ModelMapper;
import repositories.CarRepository;
import repositories.UserRepository;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;


public class CarRepositoryImpl  implements CarRepository {
    private final ModelMapper mapper;

    private final UserRepository userRepository;
    private final EntityManager em;
    @Inject
    public CarRepositoryImpl(ModelMapper mapper, UserRepository userRepository, EntityManager em){
        this.mapper = mapper;
        this.userRepository = userRepository;

        this.em = em;
    }
    @Override
    public void createCar(Car carModel, String username) {
        Car car = this.mapper.map(carModel, Car.class);
        User user = this.userRepository.findUserByUsername(username);
        car.setUser(user);

        this.em.getTransaction().begin();
        this.em.persist(car);
        this.em.getTransaction().commit();
    }

    @Override
    public List<Car> getAllCars() {
        return this.em.createQuery("select  c from Car c ", Car.class).getResultList();
    }
}
