package app.web.beans;

import app.domain.models.view.UserDetailsVeiwModel;
import app.services.UserService;
import org.modelmapper.ModelMapper;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

@Named
@RequestScoped
public class ProfileDetailsBean {
    private ModelMapper modelMapper;
    private UserService userService;
    private UserDetailsVeiwModel model;

    public ProfileDetailsBean() {
    }
    @Inject
    public ProfileDetailsBean(ModelMapper modelMapper, UserService userService) {
        this.modelMapper = modelMapper;
        this.userService = userService;
    }
    @Inject
    public void init(){
       String username = ((HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest()).getParameter("username");
        this.model = this.modelMapper.map(this.userService.getByUsername(username), UserDetailsVeiwModel.class);
        this.model.setGender(this.model.getGender().toLowerCase());
    }

    public UserDetailsVeiwModel getModel() {
        return model;
    }

    public void setModel(UserDetailsVeiwModel model) {
        this.model = model;
    }
}
