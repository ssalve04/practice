package com.baeldungtutorial.basictutorialbaeldung.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class BaseController {

    @Value("${spring.application.name}")
    String appname;

    @GetMapping("home")
    public String homePage(Model model){
       model.addAttribute("appName",appname);
        return "home";
    }
}
