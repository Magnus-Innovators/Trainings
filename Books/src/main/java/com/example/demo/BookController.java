package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {
	
	private List<Book> booksRepo = new ArrayList<>();
	
	private void initBooks() {
		Book book1 = new Book();
		book1.setName("SpringBoot");
		book1.setAuthor("James Lee");
		booksRepo.add(book1);
	}
	
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Book> getAllBooks(){
		if(booksRepo.isEmpty()) {
			
			initBooks();
		}
		
		return booksRepo;
		
	}
	
	@RequestMapping(path="/{id}", method=RequestMethod.GET)
	public Book getBook(@PathVariable("id") String name) {
		if(booksRepo.isEmpty()) {
			
			initBooks();
		}
		for(Book book:booksRepo) {
			if(book.getName().equalsIgnoreCase(name)) {
				return book;
			}
		}
		return null;
		
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Book addBook(@RequestBody Book book) {
		
		booksRepo.add(book);
		return book;
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
