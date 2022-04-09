package com.example.BookStore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.BookStore.domain.BooksRepository;
import com.example.BookStore.domain.Category;
import com.example.BookStore.domain.CategoryRepository;

@SpringBootApplication
public class BookStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BooksRepository repository, CategoryRepository repository1) {
		return (args) -> {
			repository1.save(new Category("Horror"));
			repository1.save(new Category("Romantic"));
			repository1.save(new Category("Comedy"));

		};

	}
}
