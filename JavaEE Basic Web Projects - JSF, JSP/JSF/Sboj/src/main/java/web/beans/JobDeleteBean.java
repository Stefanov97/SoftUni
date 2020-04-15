package web.beans;

import services.JobApplicationService;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Map;

@Named
@RequestScoped
public class JobDeleteBean extends BaseBean {
private JobApplicationService jobApplicationService;

    public JobDeleteBean() {
    }
    @Inject
    public JobDeleteBean(JobApplicationService jobApplicationService) {
        this.jobApplicationService = jobApplicationService;
    }

    public void deleteJob(){
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String id = params.get("id");
        this.jobApplicationService.deleteById(id);
        this.redirect("/home");
    }
}
