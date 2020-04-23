package com.stefanov.herobattles.error;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import java.net.MalformedURLException;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MalformedURLException.class)
    public ModelAndView handleWrongUrlErrors(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
