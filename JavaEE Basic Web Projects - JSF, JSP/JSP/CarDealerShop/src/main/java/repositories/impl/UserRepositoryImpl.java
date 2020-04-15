package repositories.impl;

import domain.entities.User;
import org.modelmapper.ModelMapper;
import repositories.UserRepository;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    private final ModelMapper mapper;
    private final EntityManager em;

    @Inject
    public UserRepositoryImpl(ModelMapper mapper, EntityManager em){

        this.mapper = mapper;
        this.em = em;
    }
    @Override
    public User findUserByUsername(String username) {
        List<User> users = this.em.createQuery("select  u from User u where  u.username = :username", User.class).setParameter("username", username).getResultList();
        if(!users.isEmpty()) {
            return users.get(0);
        }else {
            return null;
        }
    }


    @Override
    public User findUserByEmail(String email) {
        List<User> users = this.em.createQuery("select  u from User u where  u.email = :email", User.class).setParameter("email", email).getResultList();
        if(!users.isEmpty()) {
            return users.get(0);
        }else {
            return null;
        }
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        List<User> users = this.em.createQuery("select  u from User u where  u.username = :username AND u.password = :password", User.class)
                .setParameter("username", username)
                .setParameter("password",password)
                .getResultList();
        if(!users.isEmpty()) {
            return users.get(0);
        }else {
            return null;
        }
    }

    @Override
    public void registerUser(User user) {
        this.em.getTransaction().begin();
        this.em.persist(user);
        this.em.getTransaction().commit();
    }
}
