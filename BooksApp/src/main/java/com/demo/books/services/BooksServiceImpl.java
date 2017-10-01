package com.demo.books.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.books.model.Book;
import com.demo.books.repositories.BookRepository;

@Service("bookService")
public class BooksServiceImpl implements BooksService {
	
	@Autowired
	private BookRepository bookRepository;

	@Override
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	@Override
	public Book getBookByID(Integer id) {
		return bookRepository.findById(id);
	}

	@Override
	public Book addBook(Book book) {
		Book savedBook = bookRepository.save(book);
		return savedBook;
	}

	@Override
	public Book updateBook(Book book) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book deleteBook(Book book) {
		// TODO Auto-generated method stub
		return null;
	}

}
