package com.gokulnathv.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.gokulnathv.spring5webapp.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long>{

}
