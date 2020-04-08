package com.todolist.controllers;

import com.todolist.models.Task;
import com.todolist.storage.ObjectRelationalMapper;
import com.todolist.interfaces.ControllerInterface;

public class TaskController implements ControllerInterface {
    private ObjectRelationalMapper orm;

    public TaskController() {
        orm = new ObjectRelationalMapper();
    }

    public void create(Object task) {
        orm.addTask((Task)task);
    } 

    public Task read(String taskName) {
        return orm.findByName(taskName);
    }

    public Task[] getAll() {
        return orm.getAll();
    }

    public void update(Object updatedTask) {
        orm.updateTask((Task)updatedTask);
    }

    public void delete(int taskId) {
        orm.deleteTask(taskId);
    }
}