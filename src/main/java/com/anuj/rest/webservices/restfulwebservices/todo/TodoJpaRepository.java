package com.anuj.rest.webservices.restfulwebservices.todo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoJpaRepository extends JpaRepository<ToDo, Long>{
	
	public List<ToDo> findByUsername(String username);
	

}
