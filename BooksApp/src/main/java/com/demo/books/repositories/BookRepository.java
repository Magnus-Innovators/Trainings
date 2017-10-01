package com.demo.books.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.demo.books.model.Book;

@Component
public interface BookRepository extends JpaRepository<Book, Integer>{

		public Book findById(Integer id);
}
