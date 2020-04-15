package app.web.beans;

import app.domain.models.binding.HeroCreateBindingModel;
import app.domain.models.service.HeroServiceModel;
import app.services.HeroService;
import org.modelmapper.ModelMapper;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;


@Named
@RequestScoped
public class HeroCreateBean extends BaseBean {
    private HeroCreateBindingModel model;
    private HeroService heroService;
    private ModelMapper modelMapper;

    public HeroCreateBean() {
    }

    @Inject
    public HeroCreateBean(HeroService heroService, ModelMapper modelMapper) {
        this.heroService = heroService;
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    public void init() {
        this.model = new HeroCreateBindingModel();
    }

    public void createHero() {
        if (someFieldIsEmpty() || levelIsInvalid()) {
            return;
        }

        this.heroService.save(this.modelMapper.map(this.model, HeroServiceModel.class));
        this.redirect("/home");
    }

    private boolean levelIsInvalid() {
        return this.model.getLevel() <= 0;
    }

    private boolean someFieldIsEmpty() {
        return this.model.getName().isEmpty() || this.model.getLevel() == null;
    }

    public HeroCreateBindingModel getModel() {
        return model;
    }

    public void setModel(HeroCreateBindingModel model) {
        this.model = model;
    }
}
