package com.demo.books.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.books.model.Book;
import com.demo.books.services.BooksService;



@RestController
@RequestMapping("/books")
public class BooksController {
	
	private List<Book> booksRepo = new ArrayList<>();
	
	@Autowired
	private BooksService bookService;
	
	private void initBooks() {
		Book book1 = new Book();
		book1.setName("SpringBoot");
		book1.setAuthor("James Lee");
		booksRepo.add(book1);
	}
	
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Book> getAllBooks(){
		return bookService.getAllBooks();
		
	}
	
	@RequestMapping(path="/{id}", method=RequestMethod.GET)
	public Book getBook(@PathVariable("id") Integer id) {
		return bookService.getBookByID(id);
		
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Book addBook(@RequestBody Book book) {
		return bookService.addBook(book);
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public Book updateBook(@RequestBody Book book) {
		for(Book aBook:booksRepo) {
			if(aBook.getName().equalsIgnoreCase(book.getName())) {
				aBook.setAuthor(book.getAuthor());
				book = aBook;
				break;
			}
		}
		return book;
	}
	
	@RequestMapping(method=RequestMethod.DELETE)
	public Book deleteBook(@RequestBody Book book) {
		for(Book aBook:booksRepo) {
			if(aBook.getName().equalsIgnoreCase(book.getName())) {
				book = aBook;
				booksRepo.remove(aBook);
				break;
			}
		}
		return book;
	}
}