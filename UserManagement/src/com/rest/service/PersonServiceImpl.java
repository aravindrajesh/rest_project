package com.rest.service;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.rest.model.Person;
import com.rest.model.Response;
import com.rest.dao.PersonDao;

@Path("/person")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PersonServiceImpl implements PersonService {

	
	@Override
	@POST
    @Path("/add")
	public Response addPerson(Person p) {
		
		Response response = new Response();
		PersonDao personDao= new PersonDao();
		
		if(p.getAction().equals("ADD")) {
		personDao.insertPerson(p,p.getFirstname(),p.getLastname(),p.getEmailid());
		response.setStatus(true);
		response.setMessage("Person created successfully");
		response.setUserid(p.getId());
		response.setFirstname(p.getFirstname());
		response.setLastname(p.getLastname());
		
		}
		
		return response;
	}
	
	@Override
	@POST
    @Path("/list")
	public List<Person> getAllPersons(Person p) {
		
		Response response = new Response();
		PersonDao personDao= new PersonDao();
		List<Person> pList = new ArrayList<>();
		if(p.getAction().equals("LIST")) {
		pList = personDao.retreivePerson();
		}
		
		return pList;
	}
	
	
}
