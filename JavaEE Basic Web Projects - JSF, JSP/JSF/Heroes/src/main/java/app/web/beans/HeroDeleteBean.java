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
import java.util.Map;

@Named
@RequestScoped
public class HeroDeleteBean extends BaseBean {
    private HeroService heroService;
    private ModelMapper modelMapper;

    public HeroDeleteBean() {
    }

    @Inject
    public HeroDeleteBean(HeroService heroService, ModelMapper modelMapper) {
        this.heroService = heroService;
        this.modelMapper = modelMapper;
    }

    public void deleteHero() {
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String id = params.get("id");
        this.heroService.deleteById(id);
        this.redirect("/home");
    }
    public HeroDetailsViewModel getHeroById(String id){
        HeroDetailsViewModel hero = this.modelMapper.map(this.heroService.getById(id), HeroDetailsViewModel.class);
        hero.setClazz(hero.getClazz().substring(0,1) + hero.getClazz().substring(1).toLowerCase());
        return hero;
    }

}
