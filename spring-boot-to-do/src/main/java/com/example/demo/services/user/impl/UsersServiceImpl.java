package com.example.demo.services.user.impl;

import com.example.demo.DTO.UsersDTO;
import com.example.demo.config.AppConfig;
import com.example.demo.entity.Users;
import com.example.demo.repository.UsersRepository;
import com.example.demo.services.user.UsersService;
import jakarta.transaction.Transactional;
import org.apache.catalina.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional
@Service
public class UsersServiceImpl implements UsersService {

    UsersRepository usersRepository;
    ModelMapper modelMapper;

    @Autowired
    public UsersServiceImpl(UsersRepository usersRepository,ModelMapper modelMapper) {
        this.usersRepository = usersRepository;
        this.modelMapper=modelMapper;
    }

    @Override
    public List<Users> allGetUsers() {
        List<Users> users=usersRepository.findAll();
        return users;
    }

    @Override
    public Users getById(int id) {
        Optional<Users> u=usersRepository.findById(id);
        Users users=null;
        if(u.isPresent()){
            users=u.get();
        }
        else{
            throw new RuntimeException("Girilen id bulunamadı.");
        }
        return users;
    }

    @Override
    public void delete(int id) {
        usersRepository.deleteById(id);
    }

    @Override
    public Users saveUsers(Users users) {
        return usersRepository.save(users);
    }
}
