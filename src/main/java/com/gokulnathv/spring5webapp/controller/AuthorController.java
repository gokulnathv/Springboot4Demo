/**
 * 
 */
package com.gokulnathv.spring5webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gokulnathv.spring5webapp.repositories.AuthorRepository;

/**
 * @author ADMIN
 *
 */
@Controller
public class AuthorController {
	
	private AuthorRepository authorRepository;
	
	
	public AuthorController(AuthorRepository authorRepository) {
		super();
		this.authorRepository = authorRepository;
	}


	@RequestMapping("/authors")
	public String getAuthors(Model model) {
		model.addAttribute("authors", authorRepository.findAll());
		return "authors/list";
	}

}
