package com.example.BookStore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.BookStore.domain.Book;
import com.example.BookStore.domain.BooksRepository;
import com.example.BookStore.domain.CategoryRepository;

@Controller
public class BookController {
	@Autowired
	private BooksRepository repository;
	@Autowired
	private CategoryRepository repository1;

	@RequestMapping(value = { "/", "/booklist" })
	public String booklist(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}

	@GetMapping("/delete/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public String deletebook(@PathVariable("id") Long bookId, Model model) {
		repository.deleteById(bookId);
		return "redirect:../booklist";
	}

	@RequestMapping("/add")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", repository1.findAll());
		return "addbook";
	}

	@PostMapping("/save")
	public String save(Book book) {
		repository.save(book);
		return "redirect:booklist";
	}

	@GetMapping("/edit/{id}")
	public String editBook(@PathVariable("id") Long bookId, Model model) {
		model.addAttribute("book", repository.findById(bookId));
		model.addAttribute("categories", repository1.findAll());
		return "edit";
	}

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping(value = "/booklist1")
	public @ResponseBody List<Book> bookListRest() {
		return (List<Book>) repository.findAll();
	}

	@GetMapping(value = "/booklist/{id}")
	public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long bookId) {
		return repository.findById(bookId);
	}

}
