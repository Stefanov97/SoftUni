package web.beans;

import domain.entities.Sector;
import domain.models.binding.JobApplicationBindingModel;
import domain.models.service.JobApplicationServiceModel;
import org.modelmapper.ModelMapper;
import services.JobApplicationService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class CreateJobBean extends BaseBean {
    private JobApplicationService jobApplicationService;
    private  ModelMapper mapper;
    private JobApplicationBindingModel job;
    private List<String> validSectors;

    public CreateJobBean(){
    }
    @Inject
    public CreateJobBean(JobApplicationService jobApplicationService, ModelMapper mapper) {
        this.jobApplicationService = jobApplicationService;
        this.mapper = mapper;
    }
    @PostConstruct
    public void init(){
        this.job = new JobApplicationBindingModel();
        this.validSectors  = new ArrayList<>();
        validSectors.add("medicine");
        validSectors.add("car");
        validSectors.add("food");
        validSectors.add("domestic");
        validSectors.add("security");
    }

    public void createJob(){
        if(someFieldIsEmpty()){
            return;
        }
        if(!this.validSectors.contains(this.job.getSector().toLowerCase())){
            return;
        }
        JobApplicationServiceModel jobApplicationServiceModel = this.mapper.map(job, JobApplicationServiceModel.class);
        jobApplicationServiceModel.setSector(Sector.valueOf(this.job.getSector().toUpperCase()));
        this.jobApplicationService.addJob(jobApplicationServiceModel);
        this.redirect("/home");
    }

    private boolean someFieldIsEmpty() {
        return job.getSector().isEmpty() || job.getProfession().isEmpty() || job.getSalary() == null || job.getDescription().isEmpty();
    }

    public JobApplicationBindingModel getJob() {
        return job;
    }

    public void setJob(JobApplicationBindingModel job) {
        this.job = job;
    }
}
