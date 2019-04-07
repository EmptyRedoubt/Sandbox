package com.SaladinA.HS.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SaladinA.HS.repository.PersonRepository;

/**
 * This class is a rest controller for persons imported by the csv. This class
 * uses the annotations RestController and RequestMapping to set up Spring's
 * wiring of rest services to the specified URL.
 * 
 * @author Amber Saladin
 */
@RestController
@RequestMapping(value = PersonController.REST_URL)
public class PersonController {
	static final String REST_URL = "/personlist";
	private PersonRepository pRepo;

	@Autowired
	public PersonController(PersonRepository repository) {
		this.pRepo = repository;
	}

	/**
	 * getAll accesses the PersonRepository to find all data stored. The GetMapping
	 * is Spring's annotation for the get request
	 * 
	 * @return Will return a list of all person objects and corresponding data.
	 * @throws IOException
	 */
	@GetMapping
	public List getAll() throws IOException {
		return pRepo.findAll();
	}

}
