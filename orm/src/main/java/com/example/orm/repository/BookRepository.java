package com.example.orm.repository;

import com.example.orm.models.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BookRepository extends CrudRepository<Book, Long> {
    Optional<Book> findById(Long id);

}
