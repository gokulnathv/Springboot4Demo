/**
 * 
 */
package com.gokulnathv.spring5webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gokulnathv.spring5webapp.repositories.BooksRepository;

/**
 * @author ADMIN
 *
 */
@Controller
public class BookController {
	
	private BooksRepository bookRepository;
	
	public BookController(BooksRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}

	@RequestMapping("/books")
	public String getBooks(Model model) {
		
		model.addAttribute("books", bookRepository.findAll());
		return "books/list";
	}

}
