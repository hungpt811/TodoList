package com.hungpt.todo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hungpt.todo.Model.Todo;

@Repository
public interface TodoRepo extends JpaRepository<Todo, Integer> {

}
