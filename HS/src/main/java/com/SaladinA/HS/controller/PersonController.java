package com.SaladinA.HS.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SaladinA.HS.repository.PersonRepository;

@RestController
@RequestMapping(value = PersonController.REST_URL)
public class PersonController {
	static final String REST_URL = "/personlist";
	private PersonRepository pRepo;
	
	@Autowired
    public PersonController(PersonRepository repository) {
        this.pRepo = repository;
    }

    @GetMapping
    public List getAll() throws IOException {
        return pRepo.findAll();
    }

	
}
