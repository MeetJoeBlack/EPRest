package com.config;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Alexey Gabriel on 8/13/2015.
 */
@ControllerAdvice
public class RestResponseEntityExceptionHandler {

    @ResponseStatus(value= HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {Exception.class})
    public ModelAndView handleConflict(Exception exception, HttpServletRequest request){
        System.out.println("Error: " + exception.getMessage());
        exception.printStackTrace(System.out);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("errMsg", exception.getMessage());
        modelAndView.addObject("url", request.getRequestURL());
        modelAndView.setViewName("error");
        return modelAndView;
    }
}