package com.stefanov.herobattles.web.controllers;

import com.stefanov.herobattles.service.models.HeroServiceModel;
import com.stefanov.herobattles.service.models.ItemServiceModel;
import com.stefanov.herobattles.service.models.UserServiceModel;
import com.stefanov.herobattles.service.services.ItemService;
import com.stefanov.herobattles.service.services.UserService;
import com.stefanov.herobattles.web.models.ItemCreateModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ItemController {
    @ModelAttribute("itemCreateModel")
    public ItemCreateModel itemCreateModel(){
        return new ItemCreateModel();
    }

    private final ModelMapper mapper;
    private final ItemService itemService;
    private final UserService userService;

    public ItemController(ModelMapper mapper, ItemService itemService, UserService userService){
        this.mapper = mapper;
        this.itemService = itemService;
        this.userService = userService;
    }

    @GetMapping("/items/create")
    public ModelAndView getItemCreateForm(ModelAndView modelAndView){
        modelAndView.setViewName("/items/create-item");
        return modelAndView;
    }

    @PostMapping("/items/create")
    public ModelAndView createItem(ModelAndView modelAndView, @Valid @ModelAttribute("itemCreateModel") ItemCreateModel itemModel, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            modelAndView.setViewName("redirect:/items/create");
        }else {
            this.itemService.createItem(this.mapper.map(itemModel, ItemServiceModel.class));
            modelAndView.setViewName("redirect:/items/merchant");
        }

        return modelAndView;
    }

    @GetMapping("/items/merchant")
    public ModelAndView getMerchant(ModelAndView modelAndView,HttpSession session){
        String username = (String) session.getAttribute("username");
        UserServiceModel user = this.userService.getByUsername(username);
        HeroServiceModel hero = user.getHero();
        List<String> heroItems = hero.getItems().stream().map(ItemServiceModel::getSlot).collect(Collectors.toList());
        modelAndView.addObject("heroItems",heroItems);
        List<ItemServiceModel> items = this.itemService.getAll();
        modelAndView.addObject("items",items);
        modelAndView.setViewName("/items/merchant");
        return modelAndView;
    }

    @PostMapping("/items/merchant")
    public ModelAndView getItemsForSale(ModelAndView modelAndView, @ModelAttribute ItemCreateModel itemModel, HttpSession session){
        String username = (String) session.getAttribute("username");
        this.userService.addItemToHero(username,itemModel.getName());
        modelAndView.setViewName("redirect:/items/merchant");
        return modelAndView;
    }
}
