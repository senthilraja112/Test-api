package com.cts.testapi.TestApi.Sevice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.testapi.TestApi.Entity.BookEntity;
import com.cts.testapi.TestApi.Repo.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	public List<BookEntity> getBooks(Integer YOP){
		
		if(YOP==null) {
		List<BookEntity> bookList=new ArrayList<BookEntity>();
		bookRepository.findAll().forEach(book->bookList.add(book));
		return bookList;
		}
		else {
			return bookRepository.findAllByYearOfPublication(YOP);
		}
		
	}

	public BookEntity createBooks(BookEntity Book) {
		return bookRepository.save(Book);
	}

	public Optional<BookEntity> getBookById(Integer bookId) {
		return bookRepository.findById(bookId);
	}

	public BookEntity updateBooks(BookEntity book) {
		return bookRepository.save(book);
	}

	public void deleteBooks(Integer bookId) {
		bookRepository.deleteById(bookId);
	}

}
