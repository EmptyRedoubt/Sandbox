package com.SaladinA.HS.repository;

import java.io.IOException;
import java.util.List;

import com.SaladinA.HS.model.Person;

public interface PersonRepository {
	Person save(Person person);
	List findAll() throws IOException;
}
