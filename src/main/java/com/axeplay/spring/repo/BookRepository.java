package com.axeplay.spring.repo;

import com.axeplay.spring.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
