package com.hungpt.todo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hungpt.todo.Model.Todo;
import com.hungpt.todo.Service.ITodo;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/todo")
public class TodoController {
	@Autowired
	private ITodo todoService;
	
//	API show todo list
	@GetMapping("/list")
	public List<Todo> getAllTodo(){
		return todoService.getAllTodo();
	}
	
//	API add todo
	@PostMapping("/add")
	public Todo addTodo(@RequestBody Todo todo) {
		return todoService.addTodo(todo);
	}
	
//	API delete 1 todo
	@DeleteMapping("delete/{id}")
	public boolean deleteTodo(@PathVariable("id") Integer id) {
		return todoService.deleteTodo(id);
	}
	
//	API delete all todo
	@DeleteMapping("deleteAll")
	public void deleteAllTodo() {
		todoService.deleteAllTodo();
	}
}
