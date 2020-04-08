package com.todolist.storage;

import java.util.List;
import java.util.ArrayList;
import com.todolist.models.Task;

public class ObjectRelationalMapper {
    private List<Task> taskList;

    public ObjectRelationalMapper() {
        taskList = new ArrayList<Task>();
    }

    public void addTask(Task task) {
        taskList.add(task);
    }

    public Task findByName(String taskName) {
        for(Task task : taskList)
            if(task.getTaskName().equals(taskName))
                return task;
        return null;
    }

    public void updateTask(Task task) {
        int n = taskList.size();
        for(int i = 0; i < n; ++i)
            if(taskList.get(i).getId() == task.getId())
                taskList.set(i, task);
    }

    public void deleteTask(int id) {
        int n = taskList.size();
        for(int i = 0; i < n; ++i)
            if(taskList.get(i).getId() == id)
                taskList.remove(i);
    }

    public Task[] getAll() {
        Task[] tasks = new Task[taskList.size()];
        for(int i = 0; i < tasks.length; ++i)
            tasks[i] = taskList.get(i);
        return tasks;
    }

}