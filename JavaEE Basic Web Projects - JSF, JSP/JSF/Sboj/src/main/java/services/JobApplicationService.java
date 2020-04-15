package services;

import domain.models.service.JobApplicationServiceModel;

import java.util.List;

public interface JobApplicationService {
    List<JobApplicationServiceModel> getAll();
    void deleteById(String id);
    JobApplicationServiceModel getById(String id);
    void addJob(JobApplicationServiceModel job);
}
