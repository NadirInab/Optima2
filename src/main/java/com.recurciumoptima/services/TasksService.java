package com.recurciumoptima.services;

import com.recurciumoptima.module.Task;
import com.recurciumoptima.repository.TasksRepo;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class TasksService {
    private final EntityManagerFactory entityManagerFactory;
    private final TasksRepo tasksRepo;

    public TasksService() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("default");
        this.tasksRepo = new TasksRepo(entityManagerFactory);

    }

    public void addTask(Task task){
        tasksRepo.add(task);
    }

    public List<Task> getAllTasks() {
        return tasksRepo.getTasks();
    }

    public void deleteTask(int id) {
        tasksRepo.delete(id);
    }
}