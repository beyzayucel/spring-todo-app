package com.example.demo.services.user;
import com.example.demo.DTO.UsersDTO;
import com.example.demo.entity.Users;

import java.util.List;

public interface UsersService {
    public List<Users> allGetUsers();
    public Users getById(int id);
    public void delete(int id);
    public Users saveUsers(Users users);

}
