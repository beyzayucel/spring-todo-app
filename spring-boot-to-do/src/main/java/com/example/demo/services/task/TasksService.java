package com.example.demo.services.task;

import com.example.demo.DTO.TasksDTO;
import com.example.demo.entity.Tasks;

import java.util.List;

public interface TasksService {

    public List<Tasks> allGetTasks();
    public Tasks getById(int id);
    public void delete(int id);
    public Tasks saveTasks(Tasks tasks);
    //public Tasks update(int id);


}
