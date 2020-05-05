package com.anuj.rest.webservices.restfulwebservices.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ToDoHardcodedService {
	
	private static long idCounter = 0;
	private static List<ToDo> todos = new ArrayList<ToDo>();
	
	static {	
		todos.add(new ToDo(++idCounter, "anuj", "Learn To Dancing", new Date(), false));
		todos.add(new ToDo(++idCounter, "anuj", "Learn Angular", new Date(), false));
		todos.add(new ToDo(++idCounter, "anuj", "Fat to Fit", new Date(), false));
		todos.add(new ToDo(++idCounter, "anuj", "Learn Python", new Date(), false));
	}

	public List<ToDo> findAll(){
		return todos;
	}
	public ToDo deleteById(long id){
		ToDo todo = findById(id);
		if(todo==null) return null;
		if(todos.remove(todo)){
		return todo;
		}
		return null;
	}
	public ToDo findById(long id) {
		// TODO Auto-generated method stub
		for(ToDo todo : todos) {
			if(todo.getId()==id) {
				return todo;
			}
		}
		return null;
	}
	//In JPA save method do insert as well as update
	public ToDo save(ToDo todo) {
		//if id is -1 then it means we need to insert
		if (todo.getId() == -1 || todo.getId()==0) {
			todo.setId(++idCounter);
			todos.add(todo);

		} else {
			//here we are updating
			deleteById(todo.getId());
			todos.add(todo);
		}
		return todo;
	}
}
