package com.example.TodoList.service;

import com.example.TodoList.dao.TodoDAO;
import com.example.TodoList.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoDAO todoDAO;

    public int create(Todo todo) {
        return todoDAO.create(todo);
    }

    public List<Todo> getAll() {
        return todoDAO.getAll();
    }

    public Todo getById(int id) {
        return todoDAO.getById(id);
    }

    public int update(Todo todo) {
        return todoDAO.update(todo);
    }

    public int delete(int id) {
        return todoDAO.delete(id);
    }

    public String getName(){return "Vipul";}
}

