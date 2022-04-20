package com.example.BookStore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.BookStore.domain.Book;
import com.example.BookStore.domain.BooksRepository;
import com.example.BookStore.domain.Category;
import com.example.BookStore.domain.CategoryRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class JpaRepositoryTest {
	@Autowired
	private BooksRepository repository;
	@Autowired
	private CategoryRepository repository1;

	@Test
	public void createNewStudent() {
		Book book = new Book("Mickey", "Mouse", 1997, "137-77", 11.00, new Category("BITE"));
		repository.save(book);
		assertThat(book.getId()).isNotNull();
		repository.delete(book);
	}
}
