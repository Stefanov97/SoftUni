package web.beans;

import domain.models.view.JobApplicationViewModel;
import org.modelmapper.ModelMapper;
import services.JobApplicationService;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Map;

@Named
@RequestScoped
public class JobDetailsBean extends BaseBean {

    private ModelMapper mapper;
    private JobApplicationService jobApplicationService;


    public JobDetailsBean() {
    }

    @Inject
    public JobDetailsBean(ModelMapper mapper, JobApplicationService jobApplicationService) {
        this.mapper = mapper;
        this.jobApplicationService = jobApplicationService;
    }

    public JobApplicationViewModel getJobById(String id) {
        return this.mapper.map(this.jobApplicationService.getById(id), JobApplicationViewModel.class);
    }

}
