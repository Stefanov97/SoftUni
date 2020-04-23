package com.stefanov.herobattles.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
//    @GetMapping("/logout")
//    public ModelAndView logout(ModelAndView modelAndView, HttpSession session){
//        session.removeAttribute("username");
//        modelAndView.setViewName("redirect:/users/login");
//        return  modelAndView;
//    }

    @GetMapping("users/profile")
    public ModelAndView getUserProfile(ModelAndView modelAndView, HttpSession session){
        modelAndView.setViewName("/users/profile");
        return modelAndView;
    }
}
