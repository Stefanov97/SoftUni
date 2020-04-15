package repositories.impl;

import domain.entities.JobApplication;
import repositories.JobApplicationRepository;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

public class JobApplicationRepositoryImpl implements JobApplicationRepository {
    private final EntityManager em;

    @Inject
    public JobApplicationRepositoryImpl(EntityManager em){
        this.em = em;
    }

    @Override
    public void save(JobApplication application) {
        this.em.getTransaction().begin();
        this.em.persist(application);
        this.em.getTransaction().commit();
    }

    @Override
    public List<JobApplication> findAll() {
        return this.em.createQuery("SELECT j FROM JobApplication j",JobApplication.class).getResultList();
    }

    @Override
    public JobApplication findById(String id) {
        List<JobApplication> jobs = this.em.createQuery("SELECT j FROM JobApplication j WHERE j.id=:id", JobApplication.class).setParameter("id", id).getResultList();
        if(jobs.isEmpty()){
            return null;
        }else {
            return jobs.get(0);
        }
    }

    @Override
    public void deleteById(String id) {
        this.em.getTransaction().begin();
        this.em.createQuery("DELETE FROM  JobApplication j WHERE j.id = :id").setParameter("id", id).executeUpdate();
        this.em.getTransaction().commit();
    }
}
