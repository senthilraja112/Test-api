package com.cts.testapi.TestApi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cts.testapi.TestApi.Entity.BookEntity;
import com.cts.testapi.TestApi.Sevice.BookService;

@RestController
@RequestMapping("/test")
public class TestApiController {
	
	@Autowired
	private BookService bookservice;
	
	
	@GetMapping("/books")
	public ResponseEntity<List<BookEntity>> getBooks(@RequestParam(value="yearOfPublication", required=false) Integer YOP) {
		List<BookEntity> books = bookservice.getBooks(YOP);
		return  new ResponseEntity<List<BookEntity>>(books, HttpStatus.OK);
		
	}
	
	@PostMapping("/books")
	public ResponseEntity<BookEntity> postBooks(@RequestBody BookEntity Book) {
		BookEntity books = bookservice.createBooks(Book);
		return new ResponseEntity<BookEntity>(books,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/books/{id}")
	public ResponseEntity<?> getBookById(@PathVariable("id") Integer bookId) {
		Optional<BookEntity> bookById = bookservice.getBookById(bookId);
		if(!bookById.isEmpty()) {
			Optional.ofNullable(bookById.get().getName());
		}
		return new ResponseEntity<>(name, HttpStatus.OK);
		 
		
		
	}
	@PutMapping("/books")
	public BookEntity updateBooks(@RequestBody BookEntity book) {
		return bookservice.updateBooks(book);
		
	}
	
	@DeleteMapping("/delete/{bookId}")
	public ResponseEntity<Void> deleteBooks(@PathVariable Integer bookId) {
		 bookservice.deleteBooks(bookId);
		 return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}
	
	
	
	

}
