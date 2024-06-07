package com.example.managerHome_3.controller;


import com.example.managerHome_3.entity.Role;
import com.example.managerHome_3.entity.User;
import com.example.managerHome_3.repository.RoleRepository;
import com.example.managerHome_3.service.UserService;
import com.example.managerHome_3.web.RegisterUser;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.Collection;

@Controller
@RequestMapping("/register")
public class RegisterController {

    UserService userService;
    RoleRepository roleRepository;
    @Autowired
    public RegisterController(UserService userService, RoleRepository roleRepository) {
        this.userService = userService;
        this.roleRepository = roleRepository;
    }
    @GetMapping("/showRegisterForm")
    public String showRegisterForm(Model model){
        RegisterUser ru = new RegisterUser();
        model.addAttribute("registerUser", ru);
        return "register/form";
    }
    @InitBinder
    public void initBinder(WebDataBinder data){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        data.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @PostMapping("/process")
    public String process(@Valid @ModelAttribute("registerUser") RegisterUser registerUser,
                          BindingResult result, Model model, HttpSession session){
        String username = registerUser.getUsername();
        // form validation
        if(result.hasErrors()){
            return "register/form";
        }
        // kiểm tra user đã tồn tại?
        User userExisting =userService.findByUsername(username);
        if (userExisting!=null){
            model.addAttribute("registerUser", new RegisterUser());
            model.addAttribute("my_error", "Tài khoản đã tồn tại!");
            return "register/form";
        }
        // Nếu chưa ton tai thi luu
        BCryptPasswordEncoder bcrypt= new BCryptPasswordEncoder();
        User user = new User();
        user.setUsername(registerUser.getUsername());
        user.setPassword(bcrypt.encode(registerUser.getPassword()));
        user.setFirstName(registerUser.getFirstName());
        user.setLastName(registerUser.getLastName());
        user.setEmail(registerUser.getEmail());

        Role defaultRole = roleRepository.findByName("ROLE_USER");
        Collection<Role> roles = new ArrayList<>();
        roles.add(defaultRole);
        user.setRoles(roles);

        userService.save(user);

        // thông báo thành công
        session.setAttribute("myuser", user);

        return "register/confirmation";

    }
}
