package com.example.democ0222i1sercurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DemoController {
    @GetMapping("/home")
    public ModelAndView home(){
        return new ModelAndView("home");
    }
    @GetMapping("/admin")
    public ModelAndView admin(){
        return new ModelAndView("admin");
    }
    @GetMapping("/user")
    public ModelAndView user(){
        return new ModelAndView("user");
    }
    @GetMapping("/demo")
    public ModelAndView demo(){
        return new ModelAndView("demo");
    }
    @GetMapping("/khongcoquyen")
    public ModelAndView page403(){
        return new ModelAndView("page403");
    }
}
