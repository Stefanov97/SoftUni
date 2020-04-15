package app.web.beans;

import app.domain.models.service.UserServiceModel;
import app.domain.models.view.UserHomeViewModel;
import app.services.UserService;
import org.modelmapper.ModelMapper;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.stream.Collectors;

@Named
@RequestScoped
public class HomeBean extends BaseBean {
    private List<UserHomeViewModel> models;
    private ModelMapper modelMapper;
    private UserService userService;

    public HomeBean() {
    }
    @Inject
    public HomeBean(ModelMapper modelMapper, UserService userService) {
        this.modelMapper = modelMapper;
        this.userService = userService;
    }
    @PostConstruct
    public void init(){
        String username = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("username");


        this.setModels(this.userService
               .getAll()
               .stream()
               .filter(u-> !u.getUsername().equals(username) && !u.getFriends()
                       .stream()
                       .map(UserServiceModel::getUsername).collect(Collectors.toList())
                       .contains(username))
                .map(u-> this.modelMapper.map(u,UserHomeViewModel.class))
                .collect(Collectors.toList()));
        this.models.forEach(u->u.setGender(u.getGender().toLowerCase()));
    }

    public void addFriend(String friendUsername){
        String username = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("username");
        this.userService.addFriend(username,friendUsername);
        this.redirect("/home");
    }
    public List<UserHomeViewModel> getModels() {
        return models;
    }

    public void setModels(List<UserHomeViewModel> models) {
        this.models = models;
    }
}
