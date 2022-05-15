package com.hungpt.todo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hungpt.todo.Model.Todo;
import com.hungpt.todo.Repository.TodoRepo;
@Service
public class TodoServiceImpl implements ITodo {
	@Autowired
	private TodoRepo todoRepo;

	@Override
	public List<Todo> getAllTodo() {
		return todoRepo.findAll();
	}

	@Override
	public Todo addTodo(Todo todo) {
		if(todo != null) {
			return todoRepo.save(todo);
		}
		return null;
	}

	@Override
	public boolean deleteTodo(Integer id) {
		if(id >= 1) {
			Todo t = todoRepo.getOne(id);
			if(t != null) {
				todoRepo.delete(t);
				return true;
			}
		}
		return false;
	}

	@Override
	public void deleteAllTodo() {
		todoRepo.deleteAll();;
	}

}
