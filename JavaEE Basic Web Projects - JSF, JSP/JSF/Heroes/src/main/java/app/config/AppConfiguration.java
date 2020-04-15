package app.config;

import org.modelmapper.ModelMapper;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class AppConfiguration {
    @Produces
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Produces
    public EntityManager entityManager(){
        return Persistence
                .createEntityManagerFactory("soft_uni")
                .createEntityManager();
    }
}
