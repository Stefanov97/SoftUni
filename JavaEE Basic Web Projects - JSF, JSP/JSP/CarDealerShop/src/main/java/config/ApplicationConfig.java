package config;

import org.modelmapper.ModelMapper;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ApplicationConfig {
    @Produces
    public EntityManager entityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        return emf.createEntityManager();
    }
    @Produces
    public ModelMapper mapper(){
        return new ModelMapper();
    }
}
