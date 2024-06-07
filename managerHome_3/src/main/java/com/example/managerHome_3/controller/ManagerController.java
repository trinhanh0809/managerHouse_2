package com.example.managerHome_3.controller;


import com.example.managerHome_3.entity.House;
import com.example.managerHome_3.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/manager")
public class ManagerController {
    private HomeService homeService;
    @Autowired
    public ManagerController(HomeService homeService) {
        this.homeService = homeService;
    }



    @GetMapping
    public String listAll(Model model) {
        List<House> houses= homeService.getAllHouses();
        model.addAttribute("houses", houses);
        return "manager/manager";
    }

    @GetMapping("/list")
    public String showHome(Model model) {
        List<House> houses= homeService.getAllHouses();
        model.addAttribute("houses", houses);
        return "manager/manager";
    }
    @GetMapping("/create")
    public String create(Model model){
        House house = new House();
        model.addAttribute("house", house);
        return "house-form";
    }

    @GetMapping("/update")
    public String update(@RequestParam("id") int id, Model model) {
        House house = homeService.getHouseById(id);
        model.addAttribute("house", house);

        return "house-form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("house") House house) {
        homeService.updateHouse(house);
        return "redirect:/manager/list";
    }
}
