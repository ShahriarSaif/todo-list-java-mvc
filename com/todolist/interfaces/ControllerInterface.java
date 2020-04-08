package com.todolist.interfaces;

public interface ControllerInterface {
    public void create(Object o);
    public Object read(String s);
    public Object[] getAll();
    public void update(Object o);
    public void delete(int id);
}