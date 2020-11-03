package com.manipal.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manipal.demo.bean.ToDo;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Integer> {

}
