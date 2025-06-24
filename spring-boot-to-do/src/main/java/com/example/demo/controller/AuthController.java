//package com.example.demo.controller;
//import com.example.demo.entity.Roles;
//import com.example.demo.entity.Users;
//import com.example.demo.repository.RolesRepository;
//import com.example.demo.services.user.UsersService;
//import org.apache.catalina.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Optional;
//import java.util.Random;
//
//@Controller
//@RequestMapping("/auth")
//public class AuthController {
//    Random random;
//    UsersService usersService;
//    RolesRepository rolesRepository;
//    PasswordEncoder passwordEncoder;
//
//    @Autowired
//    public AuthController(RolesRepository rolesRepository, UsersService usersService, PasswordEncoder passwordEncoder) {
//        this.rolesRepository = rolesRepository;
//        this.usersService = usersService;
//        this.passwordEncoder=passwordEncoder;
//    }
//
//
//
//
//    @PostMapping("/register")
//    public Users processRegister(@RequestBody Users newUsers){
//        return usersService.saveUsers(newUsers);
//    }
//
//
//}
//
//
//
//
