package com.example.demo.services.auth.impl;

import com.example.demo.entity.Roles;
import com.example.demo.entity.Users;
import com.example.demo.repository.RolesRepository;
import com.example.demo.services.auth.AuthService;
import com.example.demo.services.user.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {

    UsersService usersService;
    RolesRepository rolesRepository;
    PasswordEncoder passwordEncoder;

    @Autowired
    public AuthServiceImpl(RolesRepository rolesRepository, UsersService usersService, PasswordEncoder passwordEncoder) {
        this.rolesRepository = rolesRepository;
        this.usersService = usersService;
        this.passwordEncoder=passwordEncoder;
    }

    @Override
    public void showRegisterForm(Model theModel) {
        theModel.addAttribute("users",new Users());
    }

    @Override
    public void processRegister(Users newUsers) {
        Optional<Roles> roles= rolesRepository.findById(2);
        newUsers.addRoles(roles.get());
        String hashPassword=passwordEncoder.encode(newUsers.getPassword());
        newUsers.setPassword(hashPassword);
        usersService.saveUsers(newUsers);
    }
}
