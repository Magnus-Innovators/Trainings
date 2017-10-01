package com.demo.books.services;

import java.util.List;

import com.demo.books.model.Book;

public interface BooksService {
	
	public List<Book> getAllBooks();
	
	public Book getBookByID(Integer id);
	
	public Book addBook(Book book);
	
	public Book updateBook(Book book);
	
	public Book deleteBook(Book book);

}
