package com.ianrogers.modelviewcontroller.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ianrogers.modelviewcontroller.models.Book;
import com.ianrogers.modelviewcontroller.repositories.BookRepository;

@Service
public class BookService {
	private final BookRepository br;
	
	public BookService(BookRepository br) {
		this.br = br; 
	}
	
	public List<Book> allBooks() {
        return br.findAll();
    } 
    // creates a book
    public Book createBook(Book b) {
        return br.save(b);
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = br.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
    	Optional<Book> optionalBook = br.findById(id);
    	if(optionalBook.isPresent()) {
    		Book book = optionalBook.get();
    		book.setTitle(title);
    		book.setDescription(desc);
    		book.setLanguage(lang);
    		book.setNumberOfPages(numOfPages);
    		br.save(book);
    		return book;
    	} else {
    		return null;
    	}
    }
    
    public void deleteBook(Long id) {
    	br.deleteById(id);
    }
    
    public Book updateBook(Book b) {
    	return br.save(b);
    }

}
