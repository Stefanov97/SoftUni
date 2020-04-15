package app.web.beans;

import app.domain.entities.Gender;
import app.domain.models.binding.UserRegisterBindingModel;
import app.domain.models.service.UserServiceModel;
import org.apache.commons.codec.digest.DigestUtils;
import org.modelmapper.ModelMapper;
import app.services.UserService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class UserRegisterBean extends BaseBean {
    private ModelMapper mapper;
    private UserRegisterBindingModel user;
    private UserService userService;
    private List<String> validGenders;

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
        this.validGenders = new ArrayList<>();
        validGenders.add("male");
        validGenders.add("female");

    }

    public void register() {
       if(someFieldIsEmpty() || passwordsDontMatch()){
           return;
       }
        if(!this.validGenders.contains(this.user.getGender().toLowerCase())) {
            return;
        }

        String url = "";
        this.user.setPassword(DigestUtils.sha256Hex(this.user.getPassword()));
        try {
            this.userService.register(this.mapper.map(this.user, UserServiceModel.class));
            this.redirect("/login");
        } catch (IllegalAccessException e) {
            this.redirect("/register");
        }
    }

    private boolean passwordsDontMatch() {
        return !user.getPassword().equals(user.getConfirmPassword());
    }

    private boolean someFieldIsEmpty() {
        return user.getUsername().isEmpty() || user.getPassword().isEmpty() || user.getConfirmPassword().isEmpty() || user.getGender().isEmpty();
    }

    public UserRegisterBindingModel getUser() {
        return user;
    }

    public void setUser(UserRegisterBindingModel user) {
        this.user = user;
    }
}
