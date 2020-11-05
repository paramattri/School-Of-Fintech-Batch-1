package com.manipal.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.manipal.demo.bean.ToDo;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Integer> {
	List<ToDo> findByUserName(String userName);
	
	@Query("SELECT t from ToDo t WHERE t.iscompleted=true")
	List<ToDo> findByAllCompletedToDos();

}
