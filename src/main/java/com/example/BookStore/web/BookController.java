package com.example.BookStore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.BookStore.domain.BooksRepository;

@Controller
public class BookController {
	@Autowired
	private BooksRepository repository;

	@GetMapping("/index")
	public String metodi() {

		return "index";
	}

}
