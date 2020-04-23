package com.stefanov.herobattles.web.controllers;

import com.stefanov.herobattles.error.HeroNotFoundException;
import com.stefanov.herobattles.service.models.HeroServiceModel;
import com.stefanov.herobattles.service.models.ItemServiceModel;
import com.stefanov.herobattles.service.services.HeroService;
import com.stefanov.herobattles.service.services.UserService;
import com.stefanov.herobattles.web.models.HeroCreateModel;
import com.stefanov.herobattles.web.models.HeroHomeViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HeroController {
    @ModelAttribute("heroCreateModel")
    public HeroCreateModel heroCreateModel() {
        return new HeroCreateModel();
    }

    private final UserService userService;
    private final ModelMapper mapper;
    private final HeroService heroService;

    @Autowired
    public HeroController(UserService userService, ModelMapper mapper, HeroService heroService) {
        this.userService = userService;
        this.mapper = mapper;
        this.heroService = heroService;
    }

    @GetMapping("/heroes/create")
    public ModelAndView getHeroCreateForm(ModelAndView modelAndView) {
        modelAndView.setViewName("/heroes/create-hero");
        return modelAndView;
    }

    @PostMapping("/heroes/create")
    public ModelAndView createHero(ModelAndView modelAndView, @Valid @ModelAttribute("heroCreateModel") HeroCreateModel heroCreateModel, BindingResult bindingResult, HttpSession session) {
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("redirect:/heroes/create");
        } else {
            String username = (String) session.getAttribute("username");
            HeroServiceModel hero = this.mapper.map(heroCreateModel, HeroServiceModel.class);
            this.userService.addHero(username, hero);
            modelAndView.setViewName("redirect:/home");
//            session.setAttribute("heroName", hero.getName());
//            session.setAttribute("heroGender", hero.getGender().toLowerCase());
        }

        return modelAndView;
    }

    @GetMapping("/heroes/details/{name}")
    public ModelAndView getHeroDetails(ModelAndView modelAndView, @PathVariable String name) {
        HeroServiceModel hero = this.heroService.getByName(name);
        List<String> items = hero.getItems().stream().map(ItemServiceModel::getSlot).collect(Collectors.toList());
        modelAndView.addObject("hero", hero);
        modelAndView.addObject("items", items);
        modelAndView.setViewName("/heroes/hero-details");
        return modelAndView;
    }

    @ExceptionHandler(HeroNotFoundException.class)
    public ModelAndView handleException(HeroNotFoundException exception) {
        ModelAndView modelAndView = new ModelAndView("hero-not-found");
        modelAndView.addObject("error", exception.getMessage());
        modelAndView.setStatus(HttpStatus.NOT_FOUND);
        return modelAndView;
    }

    @GetMapping("/heroes/fight/{opponentName}")
    public ModelAndView getFightPage(ModelAndView modelAndView, @PathVariable String opponentName, HttpSession session) {
        String heroName = (String) session.getAttribute("heroName");
        String winner = this.heroService.fight(heroName, opponentName);
        HeroHomeViewModel hero = this.mapper.map(this.heroService.getByName(heroName),HeroHomeViewModel.class);
        HeroHomeViewModel opponent = this.mapper.map(this.heroService.getByName(opponentName),HeroHomeViewModel.class);
        modelAndView.addObject("winner", winner);
        modelAndView.addObject("hero", hero);
        modelAndView.addObject("opponent", opponent);
        modelAndView.setViewName("/heroes/fight");
        return modelAndView;
    }

}
