package app.repositories.impl;

import app.domain.entities.User;
import app.repositories.UserRepository;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    private final EntityManager em;

    @Inject
    public UserRepositoryImpl(EntityManager em) {
        this.em = em;
    }


    @Override
    public void save(User user) {
        this.em.getTransaction().begin();
        this.em.persist(user);
        this.em.getTransaction().commit();
    }

    @Override
    public List<User> findAll() {
        return this.em.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Override
    public User findByUsername(String username) {
        List<User> users = this.em.createQuery("select  u from User u where  u.username = :username", User.class).setParameter("username", username).getResultList();
        if(!users.isEmpty()) {
            return users.get(0);
        }else {
            return null;
        }
    }

    @Override
    public User findByEmail(String email) {
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

}
