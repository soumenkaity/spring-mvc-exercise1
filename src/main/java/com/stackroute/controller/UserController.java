package com.stackroute.controller;

import com.stackroute.model.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@ComponentScan("com.stackroute.model")
public class UserController {

    @RequestMapping("/")
    public ModelAndView getName() {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(User.class);
        User user = context.getBean("user", User.class);

        ModelAndView mv=new ModelAndView("index");
        mv.addObject("name", user.getName());

        return mv;
    }

}