package app.web.beans;

import app.domain.models.view.HeroDetailsViewModel;
import app.services.HeroService;
import org.modelmapper.ModelMapper;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

@Named
@RequestScoped
public class HeroDetailsBean extends BaseBean {
    private HeroDetailsViewModel model;
    private HeroService heroService;
    private ModelMapper modelMapper;

    public HeroDetailsBean() {
    }

    @Inject
    public HeroDetailsBean(HeroService heroService, ModelMapper modelMapper) {
        this.heroService = heroService;
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    public void init() {
        String id = ((HttpServletRequest) FacesContext
                .getCurrentInstance()
                .getExternalContext()
                .getRequest())
                .getParameter("id");
        this.model = this.modelMapper.map(this.heroService.getById(id), HeroDetailsViewModel.class);
        this.model.setClazz(this.model.getClazz().substring(0,1) + this.model.getClazz().substring(1).toLowerCase());
    }

    public HeroDetailsViewModel getModel() {
        return model;
    }

    public void setModel(HeroDetailsViewModel model) {
        this.model = model;
    }
}
