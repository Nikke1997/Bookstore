package com.example.BookStore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BooksRepository extends CrudRepository<Book, Long> {
	List<Book> findByTitle(String title);

}
