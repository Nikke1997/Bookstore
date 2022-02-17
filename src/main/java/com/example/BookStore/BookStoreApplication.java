package com.example.BookStore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.BookStore.domain.Book;
import com.example.BookStore.domain.BooksRepository;

@SpringBootApplication
public class BookStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BooksRepository repository) {
		return (args) -> {

			repository.save(new Book("Once", "Niklas", 1997, "978-3", 10.00));
			repository.save(new Book("Upon", "Kate", 1998, "977-5", 11.00));

		};

	}
}
