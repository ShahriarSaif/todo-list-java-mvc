package com.todolist.models;

import java.util.Date;

public class Task {
    private int id;
    private String taskName;
    private boolean isDone;
    private Date taskCreated, taskCompleted, deadline;
    private static int autoIncrementingId = 0;

    public Task(String taskName, Date deadline) {
        id = ++autoIncrementingId;
        this.taskName = taskName;
        this.deadline = deadline;
        isDone = false;
        taskCreated = new Date();
    }

    public int getId() {
        return id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Date getTaskCreated() {
        return taskCreated;
    }

    public Date getTaskCompleted() {
        return taskCompleted;
    }

    public void setTaskCompleted(Date taskCompleted) {
        this.taskCompleted = taskCompleted;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadLine) {
        this.deadline = deadLine;
    }

    public boolean getIsDone() {
        return isDone;
    }

    public void setIsDone(boolean isDone) {
        this.isDone = isDone;
    }
}