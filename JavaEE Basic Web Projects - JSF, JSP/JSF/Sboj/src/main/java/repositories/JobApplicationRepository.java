package repositories;

import domain.entities.JobApplication;

import java.util.List;

public interface JobApplicationRepository {
    void save(JobApplication application);
    List<JobApplication> findAll();
    JobApplication findById(String id);
    void deleteById(String id);
}
