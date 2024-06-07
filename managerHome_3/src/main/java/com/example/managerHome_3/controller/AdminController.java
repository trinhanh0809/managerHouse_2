package com.example.managerHome_3.controller;

import com.example.managerHome_3.entity.House;
import com.example.managerHome_3.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private HomeService homeService;
    @Autowired
    public AdminController(HomeService homeService) {
        this.homeService = homeService;
    }
//    @GetMapping
//    public String showHomePage() {
//        return "admin/admin";
//    }
    @GetMapping
    public String listAll(Model model) {
        List<House> houses= homeService.getAllHouses();
        model.addAttribute("houses", houses);
        return "admin/admin";
}

    @GetMapping("/list")
    public String showHome(Model model) {
        List<House> houses = homeService.getAllHouses();
        model.addAttribute("houses", houses);
        return "admin/admin";
    }


    @GetMapping("/create")
    public String create(Model model){
        House house = new House();
        model.addAttribute("house", house);
        return "house-form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("house") House house) {
        homeService.updateHouse(house);
        return "redirect:/manager/list";
    }
//
    @GetMapping("/update")
    public String update(@RequestParam("id") int id, Model model) {
        House house = homeService.getHouseById(id);
        model.addAttribute("house", house);

        return "house-form";
    }


    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id) {
        homeService.deleteHouse(id);
        return "redirect:/admin/list";
    }

}
