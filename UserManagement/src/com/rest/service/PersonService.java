package com.rest.service;



import java.util.List;

import com.rest.model.Person;
import com.rest.model.Response;

public interface PersonService {

	public Response addPerson(Person p);
	
	public List<Person> getAllPersons(Person p);

}