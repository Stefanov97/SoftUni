package app.web.beans;

import app.domain.models.view.UserFriendsViewModel;
import app.services.UserService;
import org.modelmapper.ModelMapper;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class FriendsBean extends BaseBean {
    private UserFriendsViewModel model;
    private ModelMapper modelMapper;
    private UserService userService;

    public FriendsBean() {
    }
    @Inject
    public FriendsBean(ModelMapper modelMapper, UserService userService) {
        this.modelMapper = modelMapper;
        this.userService = userService;
    }
    @PostConstruct
    public void init(){
        String username = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("username");
        this.setModel(this.modelMapper.map(this.userService.getByUsername(username),UserFriendsViewModel.class));
    }

    public void removeFriend(String friendUsername){
        String username = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("username");
        this.userService.removeFriend(username,friendUsername);
        this.redirect("/friends");

    }
    public UserFriendsViewModel getModel() {
        return model;
    }

    public void setModel(UserFriendsViewModel model) {
        this.model = model;
    }
}
