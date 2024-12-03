package com.example.TodoList.dao;

import com.example.TodoList.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TodoDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int create(Todo todo) {
        String sql = "INSERT INTO todo (title, description, status) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, todo.getTitle(), todo.getDescription(), todo.getStatus());
    }

    public List<Todo> getAll() {
        String sql = "SELECT * FROM todo";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Todo todo = new Todo();
            todo.setId(rs.getInt("id"));
            todo.setTitle(rs.getString("title"));
            todo.setDescription(rs.getString("description"));
            todo.setStatus(rs.getString("status"));
            return todo;
        });
    }

    public Todo getById(int id) {
        String sql = "SELECT * FROM todo WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
            Todo todo = new Todo();
            todo.setId(rs.getInt("id"));
            todo.setTitle(rs.getString("title"));
            todo.setDescription(rs.getString("description"));
            todo.setStatus(rs.getString("status"));
            return todo;
        });
    }

    public int update(Todo todo) {
        String sql = "UPDATE todo SET title = ?, description = ?, status = ? WHERE id = ?";
        return jdbcTemplate.update(sql, todo.getTitle(), todo.getDescription(), todo.getStatus(), todo.getId());
    }

    public int delete(int id) {
        String sql = "DELETE FROM todo WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }
}

