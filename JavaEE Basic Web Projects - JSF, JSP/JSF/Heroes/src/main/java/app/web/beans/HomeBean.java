package app.web.beans;

import app.domain.models.view.HeroHomeViewModel;
import app.services.HeroService;
import org.modelmapper.ModelMapper;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.stream.Collectors;

@Named
@RequestScoped
public class HomeBean extends BaseBean {
    private List<HeroHomeViewModel> models;
    private HeroService heroService;
    private ModelMapper modelMapper;

    public HomeBean() {
    }

    @Inject
    public HomeBean(HeroService heroService, ModelMapper modelMapper) {
        this.heroService = heroService;
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    public void init() {
        this.models = this.heroService.getAll().stream().sorted((f, s) -> s.getLevel() - f.getLevel()).map(h -> this.modelMapper.map(h, HeroHomeViewModel.class)).collect(Collectors.toList());
        this.models.forEach(h -> h.setClazz(h.getClazz().toLowerCase()));
    }

    public List<HeroHomeViewModel> getModels() {
        return models;
    }

    public void setModels(List<HeroHomeViewModel> models) {
        this.models = models;
    }
}
