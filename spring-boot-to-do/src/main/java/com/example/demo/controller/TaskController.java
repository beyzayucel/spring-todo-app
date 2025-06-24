package com.example.demo.controller;


import com.example.demo.DTO.TasksDTO;
import com.example.demo.entity.Tasks;
import com.example.demo.services.task.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/tasks")
public class TaskController {

    @Value("${important}")
    private List<String> important;

    TasksService tasksService;

    @Autowired
    public TaskController(TasksService tasksService) {
        this.tasksService = tasksService;
    }

    @GetMapping("/list")
    public List<TasksDTO> getTaskList(){
        List<Tasks> tasks= tasksService.allGetTasks();
        return
    }

    @PostMapping("/saveTasks")
    public void save(@RequestBody Tasks theTasks){
         tasksService.saveTasks(theTasks);

    }

    @PostMapping("/update")
    public Tasks update(@RequestBody Tasks newTasks, @RequestParam("id") int theId){
        Tasks oldTasks=tasksService.getById(theId);
        oldTasks.setTaskName(newTasks.getTaskName());
        oldTasks.setStartedDate(newTasks.getStartedDate());
        oldTasks.setFinishDate(newTasks.getFinishDate())    ;
        oldTasks.setCompleted(newTasks.getCompleted());
        oldTasks.setImportant(newTasks.getImportant());

        return tasksService.saveTasks(oldTasks);

    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam(value = "id") int theId){
        tasksService.delete(theId);
    }

}
