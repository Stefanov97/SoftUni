package com.stefanov.herobattles.web.controllers;

import com.stefanov.herobattles.service.models.HeroServiceModel;
import com.stefanov.herobattles.service.models.ItemServiceModel;
import com.stefanov.herobattles.service.services.HeroService;
import com.stefanov.herobattles.web.models.HeroCreateModel;
import com.stefanov.herobattles.web.models.HeroHomeViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeController {
    private HeroService heroService;
    private ModelMapper mapper;

    public HomeController(HeroService heroService, ModelMapper mapper) {
        this.heroService = heroService;
        this.mapper = mapper;
    }

    @GetMapping("/")
    public ModelAndView getIndex(ModelAndView modelAndView){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (!(auth instanceof AnonymousAuthenticationToken)) {

            /* The user is logged in :) */
            return new ModelAndView("redirect:/home");
        }
        modelAndView.setViewName("/home/index");
        return modelAndView;
    }

    @GetMapping("/home")
    public ModelAndView getHomePage(ModelAndView modelAndView, HttpSession session){
        String heroName = (String) session.getAttribute("heroName");
        modelAndView.setViewName("/home/home");
        if(heroName!=null){
            List<HeroHomeViewModel> opponents = this.heroService.getAllOpponents(heroName).stream().map(h-> this.mapper.map(h,HeroHomeViewModel.class)).collect(Collectors.toList());
            HeroServiceModel hero = this.heroService.getByName(heroName);
            List<ItemServiceModel> heroItems = hero.getItems();
            modelAndView.addObject("opponents", opponents);
            modelAndView.addObject("heroItems", heroItems);
        }

        return modelAndView;
    }
}
