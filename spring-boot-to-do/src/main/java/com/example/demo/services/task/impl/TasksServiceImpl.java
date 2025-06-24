package com.example.demo.services.task.impl;

import com.example.demo.entity.Tasks;
import com.example.demo.repository.TasksRepository;
import com.example.demo.services.task.TasksService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class TasksServiceImpl implements TasksService {

    TasksRepository tasksRepository;
    ModelMapper modelMapper;


    @Autowired
    public TasksServiceImpl(TasksRepository tasksRepository,ModelMapper modelMapper) {
        this.tasksRepository = tasksRepository;
        this.modelMapper=modelMapper;
    }

    @Override
    public List<Tasks> allGetTasks() {
        return tasksRepository.findAll();

    }

    @Override
    public Tasks getById(int id) {
        Optional<Tasks> t=tasksRepository.findById(id);
        Tasks tasks=null;
        if(t.isPresent()){
            tasks=t.get();
        }
        else{
            throw new RuntimeException("Böyle bir kayıt bulunamadı");
        }
        return tasks;
    }

    @Override
    public void delete(int id) {
        tasksRepository.deleteById(id);
    }

    @Override
    public Tasks saveTasks(Tasks tasks) {
        return tasksRepository.save(tasks);
    }
}
