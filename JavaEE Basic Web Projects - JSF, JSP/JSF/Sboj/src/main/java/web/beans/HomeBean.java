package web.beans;

import domain.models.view.JobApplicationViewModel;
import org.modelmapper.ModelMapper;
import services.JobApplicationService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.stream.Collectors;

@Named
@RequestScoped
public class HomeBean extends BaseBean {
    private List<JobApplicationViewModel> jobs;
    private JobApplicationService jobService;
    private ModelMapper modelMapper;

    public HomeBean() {
    }
    @Inject
    public HomeBean(JobApplicationService jobService, ModelMapper modelMapper) {
        this.jobService = jobService;
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    public void init(){
        this.setJobs(this.jobService.getAll().stream().map(j-> this.modelMapper.map(j,JobApplicationViewModel.class)).collect(Collectors.toList()));
        this.getJobs().forEach(j -> j.setSector(j.getSector().toLowerCase()));
    }

    public List<JobApplicationViewModel> getJobs() {
        return this.jobs;
    }

    public void setJobs(List<JobApplicationViewModel> jobs) {
        this.jobs = jobs;
    }


}
