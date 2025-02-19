package com.example.harumag.controller.page;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("")
@Controller
public class DefaultController {

    @GetMapping({"", "/", "/home", "/homePage"})
    public String homePage(){
        return "homePage";
    }

    @GetMapping({"/admin"})
    public String admin(){
        return "admin";
    }

}
