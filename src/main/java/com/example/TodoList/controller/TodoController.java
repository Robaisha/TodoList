package com.example.TodoList.controller;

import com.example.TodoList.apiResponse.WeatherResponse;
import com.example.TodoList.service.TodoService;
import com.example.TodoList.model.Todo;
import com.example.TodoList.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @Autowired
    private WeatherService weatherService;

//    @GetMapping
//    public String getAllTodos(Model model) {
//        model.addAttribute("todos", todoService.getAll());
//        return "todos/list";
//    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("todo", new Todo());
        return "todos/CreateTodo";
    }

    @PostMapping("/new")
    public String createTodo(@ModelAttribute Todo todo) {
        todoService.create(todo);
        return "redirect:/todos";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        Todo todo = todoService.getById(id);
        model.addAttribute("todo", todo);
        return "todos/EditTodo";
    }

    @PostMapping("/edit/{id}")
    public String updateTodo(@PathVariable("id") int id, @ModelAttribute Todo todo) {
        todo.setId(id);
        todoService.update(todo);
        return "redirect:/todos";
    }

    @GetMapping("/delete/{id}")
    public String deleteTodo(@PathVariable("id") int id) {
        todoService.delete(id);
        return "redirect:/todos";
    }
    @GetMapping
    public ResponseEntity<?> weather() {
        WeatherResponse response=weatherService.getWeather("Mumbai");
        String greetings="";
        if(response!=null){
            greetings="Weather feels like "+response.getCurrent().getFeelslike();
        }
        return new ResponseEntity<>("Hi "+ greetings,HttpStatus.OK);
    }
}

