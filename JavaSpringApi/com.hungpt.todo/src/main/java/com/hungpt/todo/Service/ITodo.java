package com.hungpt.todo.Service;

import java.util.List;

import com.hungpt.todo.Model.Todo;

public interface ITodo {

	public List<Todo> getAllTodo();
	public Todo addTodo(Todo todo);
	public boolean deleteTodo(Integer id); 
	public void deleteAllTodo();
}
