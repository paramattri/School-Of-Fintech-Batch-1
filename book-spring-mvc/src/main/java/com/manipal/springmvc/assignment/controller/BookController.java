package com.manipal.springmvc.assignment.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.manipal.springmvc.assignment.model.Book;

@Controller
public class BookController {
	
	private ArrayList<Book> books = new ArrayList<Book>();
	
//	@RequestMapping("/")
//	public String homePage() {
//		return "home";
//	}
	
	@RequestMapping("/bookForm")
	public String bookForm() {
		return "bookForm";
	}
	
	@RequestMapping("/addBook")
	public String addBook(@ModelAttribute Book book, Model model) {
		
		books.add(book);
		//model.addAttribute("books", books);
		return "successBook";
		
	}
	
	
	@RequestMapping("/bookDetails")
	public String bookDetails(Model model) {
		
		model.addAttribute("books", books);
		return "bookDetails";
	}
	

}
