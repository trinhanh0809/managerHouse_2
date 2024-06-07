package com.example.managerHome_3.service;

import com.example.managerHome_3.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    public User findByUsername(String username);
    public void save(User user);
}
