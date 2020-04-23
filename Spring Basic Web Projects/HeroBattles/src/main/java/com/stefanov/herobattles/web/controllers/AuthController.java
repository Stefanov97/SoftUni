package com.stefanov.herobattles.web.controllers;

import com.stefanov.herobattles.service.models.UserServiceModel;
import com.stefanov.herobattles.service.services.AuthService;
import com.stefanov.herobattles.web.models.UserLoginModel;
import com.stefanov.herobattles.web.models.UserRegisterModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/users")
public class AuthController {
    private final ModelMapper mapper;
    private final AuthService authService;

    @Autowired
    public AuthController(ModelMapper mapper, AuthService authService){
        this.mapper = mapper;
        this.authService = authService;
    }

    @GetMapping("/register")
    public ModelAndView getRegisterForm(ModelAndView modelAndView){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (!(auth instanceof AnonymousAuthenticationToken)) {

            /* The user is logged in :) */
            return new ModelAndView("redirect:/home");
        }
        modelAndView.setViewName("/auth/register");
        return modelAndView;
    }

    @PostMapping("/register")
    public ModelAndView register(ModelAndView modelAndView, @ModelAttribute UserRegisterModel registerModel){
        try{
            this.authService.register(this.mapper.map(registerModel, UserServiceModel.class));
            modelAndView.setViewName("/auth/login");
        }catch (IllegalAccessException ex){
            modelAndView.setViewName("/auth/register");
        }
        return modelAndView;
    }

    @GetMapping("/login")
    public ModelAndView getLoginForm(ModelAndView modelAndView){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (!(auth instanceof AnonymousAuthenticationToken)) {

            /* The user is logged in :) */
            return new ModelAndView("redirect:/home");
        }
        modelAndView.setViewName("/auth/login");
        return modelAndView;
    }

//    @PostMapping("/login")
//    public ModelAndView login(ModelAndView modelAndView, @ModelAttribute UserLoginModel loginModel, HttpSession session){
//        try{
//            UserServiceModel user = this.authService.login(this.mapper.map(loginModel, UserServiceModel.class));
//            session.setAttribute("username",user.getUsername());
//            session.setAttribute("email", user.getEmail());
//            if(user.getHero() != null){
//                session.setAttribute("heroName",user.getHero().getName());
//                session.setAttribute("heroGender", user.getHero().getGender().toLowerCase());
//            }else {
//                session.setAttribute("heroName", null);
//                session.setAttribute("heroGender", null);
//            }
//
//            modelAndView.setViewName("redirect:/home");
//        }catch (IllegalAccessException ex){
//            modelAndView.setViewName("redirect:/users/login");
//        }
//        return modelAndView;
//    }
}
