package services.impl;

import domain.entities.JobApplication;
import domain.models.service.JobApplicationServiceModel;
import org.modelmapper.ModelMapper;
import repositories.JobApplicationRepository;
import services.JobApplicationService;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class JobApplicationServiceImpl implements JobApplicationService {
    private final JobApplicationRepository jobApplicationRepository;
    private final ModelMapper mapper;
    @Inject
    public JobApplicationServiceImpl(JobApplicationRepository jobApplicationRepository, ModelMapper mapper){
        this.jobApplicationRepository = jobApplicationRepository;
        this.mapper = mapper;
    }

    @Override
    public List<JobApplicationServiceModel> getAll() {
        return this.jobApplicationRepository.findAll().stream().map(j-> this.mapper.map(j,JobApplicationServiceModel.class)).collect(Collectors.toList());
    }

    @Override
    public void deleteById(String id) {
        this.jobApplicationRepository.deleteById(id);
    }

    @Override
    public JobApplicationServiceModel getById(String id) {
        return this.mapper.map(this.jobApplicationRepository.findById(id),JobApplicationServiceModel.class);
    }

    @Override
    public void addJob(JobApplicationServiceModel job) {
        this.jobApplicationRepository.save(this.mapper.map(job, JobApplication.class));
    }
}
