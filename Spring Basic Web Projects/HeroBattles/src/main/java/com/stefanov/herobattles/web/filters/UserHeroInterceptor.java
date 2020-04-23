package com.stefanov.herobattles.web.filters;

import com.stefanov.herobattles.service.models.HeroServiceModel;
import com.stefanov.herobattles.service.services.AuthenticatedUserService;
import com.stefanov.herobattles.service.services.HeroService;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class UserHeroInterceptor extends HandlerInterceptorAdapter {
    private final AuthenticatedUserService authenticatedUserService;
    private final HeroService heroService;

    public UserHeroInterceptor(
            AuthenticatedUserService authenticatedUserService,
            HeroService heroService) {

        this.authenticatedUserService = authenticatedUserService;
        this.heroService = heroService;
    }
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
        String username = authenticatedUserService.getUsername();
        if(!username.equals("anonymousUser")){
            request.getSession()
                    .setAttribute("username",username);
            HeroServiceModel hero = heroService.getByUsername(username);
            if(hero != null){
                request.getSession()
                        .setAttribute("heroName", hero.getName());
                request.getSession()
                        .setAttribute("heroGender", hero.getGender().toLowerCase());
                request.getSession()
                        .setAttribute("email", hero.getUser().getEmail());
            }
        }

    return true;
    }

}
