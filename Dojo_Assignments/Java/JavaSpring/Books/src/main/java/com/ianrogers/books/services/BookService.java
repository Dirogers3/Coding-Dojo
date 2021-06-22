package com.ianrogers.books.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ianrogers.books.models.Book;
import com.ianrogers.books.repositories.BookRepository;

@Service
public class BookService {
	private final BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	// returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    
    public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
    	Optional<Book> book = bookRepository.findById(id);
    	if (book.isPresent()) {
    		Book nBook = book.get();
    		nBook.setTitle(title);
    		nBook.setDescription(desc);
    		nBook.setLanguage(lang);
    		nBook.setNumberOfPages(numOfPages);
    		bookRepository.save(nBook);
    		return nBook;
    	} else {
    		return null;
    	}
    }
    
    public void deleteBook(Long id) {
    	Optional<Book> book = bookRepository.findById(id);
    	if(book.isPresent()) {
    		bookRepository.deleteById(id);
    	}
    }
}
