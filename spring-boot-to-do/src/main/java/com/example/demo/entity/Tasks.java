package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tasks")
public class Tasks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "task_name")
    private String taskName;


    @Column(name="completed")
    private String completed;

    @Column(name = "started_date")
    private String startedDate;

    @Column(name = "finish_date")
    private String finishDate;

    @Column(name = "important")
    private String important;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},mappedBy ="tasks")
    private List<Users> users;


    public void addUsers(Users theUsers){
        if(users==null){
            users=new ArrayList<>();
        }
        users.add(theUsers);
        theUsers.addTasks(this);
    }

    public Tasks() {
    }

    public Tasks(String completed, String finishDate, String important, String startedDate, String taskName, List<Users> users) {
        this.completed = completed;
        this.finishDate = finishDate;
        this.important = important;
        this.startedDate = startedDate;
        this.taskName = taskName;
        this.users = users;
    }

    public String getCompleted() {
        return completed;
    }

    public void setCompleted(String completed) {
        this.completed = completed;
    }

    public String getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(String finishDate) {
        this.finishDate = finishDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImportant() {
        return important;
    }

    public void setImportant(String important) {
        this.important = important;
    }

    public String getStartedDate() {
        return startedDate;
    }

    public void setStartedDate(String startedDate) {
        this.startedDate = startedDate;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }
}
