package web.beans;

import domain.models.binding.UserLoginBindingModel;
import domain.models.service.UserServiceModel;
import org.apache.commons.codec.digest.DigestUtils;
import org.modelmapper.ModelMapper;
import services.UserService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Map;

@Named
@RequestScoped
public class UserLoginBean extends BaseBean {
    private UserLoginBindingModel user;
    private UserService userService;
    private ModelMapper mapper;

    public UserLoginBean() {
    }

    @Inject
    public UserLoginBean(UserService userService, ModelMapper mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }

    public void login() {
        if (user.getUsername().isEmpty() || user.getPassword().isEmpty()) {
            return;
        }
        user.setPassword(DigestUtils.sha256Hex(user.getPassword()));

        try {
            this.userService.loginUser(this.mapper.map(user, UserServiceModel.class));
            Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext()
                    .getSessionMap();
            sessionMap.put("username", user.getUsername());
            this.redirect("/home");
        } catch (IllegalAccessException e) {
            this.redirect("/login");
        }
    }

    @PostConstruct
    public void init() {
        this.user = new UserLoginBindingModel();
    }

    public UserLoginBindingModel getUser() {
        return user;
    }

    public void setUser(UserLoginBindingModel user) {
        this.user = user;
    }
}
