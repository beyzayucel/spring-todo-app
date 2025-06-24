package com.example.demo.services.auth;

import com.example.demo.entity.Users;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

@Service
public interface AuthService {

    public void showRegisterForm(Model theModel);

    public void processRegister(@ModelAttribute("users") Users newUsers);
}
