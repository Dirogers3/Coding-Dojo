package com.ianrogers.modelviewcontroller.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ianrogers.modelviewcontroller.models.Book;
import com.ianrogers.modelviewcontroller.services.BookService;


@Controller
public class BooksController {
	private final BookService bs;

	public BooksController(BookService bookService) {
		super();
		this.bs = bookService;
	}
	
	@RequestMapping("/books")
	public String index(Model model) {
		List<Book> books = bs.allBooks();
		model.addAttribute("books", books);
		return "/books/index.jsp";
	}
	
	@RequestMapping("/books/new")
	public String newBook(@ModelAttribute ("book") Book book) {
		return "books/new.jsp";
	}
	
	@RequestMapping(value="/books", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		if (result.hasErrors()) {
			return "/books/new.jsp";
		} else {
			bs.createBook(book);
			return "redirect:/books";
		}
	}
	
	@RequestMapping("/books/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Book book = bs.findBook(id);
		model.addAttribute("book", book);
		return "/books/show.jsp";
	}
	
	@RequestMapping("/books/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        Book book = bs.findBook(id);
        model.addAttribute("book", book);
        return "/books/edit.jsp";
    }
    
	@RequestMapping(value="/books/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "/books/edit.jsp";
        } else {
            bs.updateBook(book);
            return "redirect:/books";
        }
    }
	
    @RequestMapping(value="/books/{id}", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
        bs.deleteBook(id);
        return "redirect:/books";
    }

	
	
	
	
}
