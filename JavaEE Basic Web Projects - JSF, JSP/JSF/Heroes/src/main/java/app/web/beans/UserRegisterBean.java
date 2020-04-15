package app.web.beans;

import app.domain.models.binding.UserRegisterBindingModel;
import app.domain.models.service.UserServiceModel;
import org.apache.commons.codec.digest.DigestUtils;
import org.modelmapper.ModelMapper;
import app.services.UserService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class UserRegisterBean extends BaseBean {
    private ModelMapper mapper;
    private UserRegisterBindingModel user;
    private UserService userService;

    public UserRegisterBean() {
    }

    @Inject
    public UserRegisterBean(ModelMapper mapper, UserService userService) {
        this.mapper = mapper;
        this.userService = userService;
    }

    @PostConstruct
    public void init() {
        this.user = new UserRegisterBindingModel();
    }

    public void register() {
       if(someFieldIsEmpty() || passwordsDontMatch()){
           return;
       }

        String url = "";
        this.user.setPassword(DigestUtils.sha256Hex(this.user.getPassword()));
        UserServiceModel userServiceModel = this.mapper.map(this.user, UserServiceModel.class);
        try {
            this.userService.register(userServiceModel);
            this.redirect("/login");
        } catch (IllegalAccessException e) {
            this.redirect("/register");
        }
    }

    private boolean passwordsDontMatch() {
        return !user.getPassword().equals(user.getConfirmPassword());
    }

    private boolean someFieldIsEmpty() {
        return user.getUsername().isEmpty() || user.getPassword().isEmpty() || user.getConfirmPassword().isEmpty() || user.getEmail().isEmpty() || user.getCountry().isEmpty();
    }

    public UserRegisterBindingModel getUser() {
        return user;
    }

    public void setUser(UserRegisterBindingModel user) {
        this.user = user;
    }
}
