package com.gokulnathv.spring5webapp.BootStrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.gokulnathv.spring5webapp.domain.Author;
import com.gokulnathv.spring5webapp.domain.Books;
import com.gokulnathv.spring5webapp.domain.Publisher;
import com.gokulnathv.spring5webapp.repositories.AuthorRepository;
import com.gokulnathv.spring5webapp.repositories.BooksRepository;
import com.gokulnathv.spring5webapp.repositories.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner {
	
	private final AuthorRepository authorRepository;
	private final BooksRepository booksRepository;
	private final PublisherRepository publisherRepository;
	
	public BootStrapData(AuthorRepository authorRepository, BooksRepository booksRepository, PublisherRepository publisherRepository) {
		super();
		this.authorRepository = authorRepository;
		this.booksRepository = booksRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		
		Publisher publisher = new Publisher("Address1", "Namakkal", "TamilNadu", 637211L, "Publisher name");
		publisherRepository.save(publisher);
		
		Author authorOne = new Author("AuthorOne", "12345");
		Books bookOne = new Books("john", "Smith", "Book title 1");
		
		authorOne.getBooks().add(bookOne);
		bookOne.getAuthors().add(authorOne);
		bookOne.setPublisher(publisher);
		publisher.getBooks().add(bookOne);
		
		authorRepository.save(authorOne);
		booksRepository.save(bookOne);
		publisherRepository.save(publisher);
		
		Author authorSecond = new Author("AuthorSecond", "45612");
		Books bookSecond = new Books("mark", "Smith", "Book title 2");
		
		authorOne.getBooks().add(bookSecond);
		bookSecond.getAuthors().add(authorSecond);
		bookSecond.setPublisher(publisher);
		
		publisher.getBooks().add(bookSecond);
		authorRepository.save(authorSecond);
		booksRepository.save(bookSecond);
		publisherRepository.save(publisher);
		
		
		
		System.out.println("BootStrap Data started");
		System.out.println("Total Book available: " + booksRepository.count());
		System.out.println("Total Publisher: " + publisherRepository.count());
		System.out.println("Total Book assigned to Publisher:" + publisher.getBooks().size());
		
	}

}
