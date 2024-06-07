package com.example.managerHome_3.controller;

import com.example.managerHome_3.entity.House;
import com.example.managerHome_3.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    HomeService homeService;
    @Autowired
    public UserController(HomeService homeService) {
        this.homeService = homeService;
    }
//    @GetMapping
//    public String showHomePage(Model model) {
//        return "user/user";
//    }
    @GetMapping
    public String listAll(Model model) {
        List<House> houses= homeService.getAllHouses();
        model.addAttribute("houses", houses);
        return "user/user";
    }

}
