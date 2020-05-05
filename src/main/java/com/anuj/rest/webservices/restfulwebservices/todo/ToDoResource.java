package com.anuj.rest.webservices.restfulwebservices.todo;

import java.net.URI;
import java.util.List;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ToDoResource {
	@Autowired
	private ToDoHardcodedService todoService;

	@GetMapping("/users/{username}/todos")
	public List<ToDo> getAllTodos(@PathVariable String username) {
		return todoService.findAll();

	}

	@GetMapping("/users/{username}/todos/{id}")
	public ToDo getTodo(@PathVariable String username, @PathVariable long id) {
		return todoService.findById(id);

	}

	// DELETE/users/{username}/todos/{id}

//	@GetMapping("/users/{username}/todos/{id}")
//	public List<ToDo> getAllTodos(@PathVariable String username, @PathVariable int id) {
//		return todoService.findAll();
//
//	}

	@DeleteMapping("/users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable long id) {
		ToDo todo = todoService.deleteById(id);
		if (todo != null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();

	}

	// Edit/Update a Todo
	// PUT /users/{username}/todos/{todo_id}
	@PutMapping("/users/{username}/todos/{id}")
	public ResponseEntity<ToDo> updateTodo(@PathVariable String username, @PathVariable long id,
			@RequestBody ToDo todo) {
		ToDo todoupdated = todoService.save(todo);
		return new ResponseEntity<ToDo>(todo, HttpStatus.OK);

	}

	// Creating a ToDo
	@PostMapping("/users/{username}/todos")
	public ResponseEntity<ToDo> createTodo(@PathVariable String username, @RequestBody ToDo todo) {
		ToDo createdTodo = todoService.save(todo);

		// return a Location
		// Get Current Location URL
		// and expand with ID {id}
		// Now taking the current location path and appending it by a new ID.
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdTodo.getId())
				.toUri();

		return ResponseEntity.created(uri).build();

	}

}
