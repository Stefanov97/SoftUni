package app.repositories.impl;

import app.domain.entities.Hero;
import app.domain.entities.User;
import app.repositories.HeroRepository;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

public class HeroRepositoryImpl implements HeroRepository {
    private final EntityManager em;
    @Inject
    public HeroRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public void save(Hero hero) {
        this.em.getTransaction().begin();
        this.em.persist(hero);
        this.em.getTransaction().commit();
    }

    @Override
    public void deleteById(String id) {
        this.em.getTransaction().begin();
        this.em.createQuery("DELETE FROM  Hero h WHERE h.id = :id").setParameter("id", id).executeUpdate();
        this.em.getTransaction().commit();
    }

    @Override
    public List<Hero> findAll() {
        return this.em.createQuery("SELECT h FROM Hero h", Hero.class).getResultList();
    }

    @Override
    public Hero findById(String id) {
        List<Hero> heroes = this.em.createQuery("select  h from Hero h WHERE  h.id = :id", Hero.class).setParameter("id", id).getResultList();
        if(!heroes.isEmpty()) {
            return heroes.get(0);
        }else {
            return null;
        }
    }
}
