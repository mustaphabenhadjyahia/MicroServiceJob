package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/job")
public class JobRestAPi {
	private String title ="hello ,i am job microservice";
	@Autowired
	private JobService jobservice;
	@RequestMapping("/hello)")
	public String sayHello() {
		System.out.println(title);
		return title;
	}
	
	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	  public ResponseEntity<Job> updateCandidat(@PathVariable(value = "id") int id){
return new ResponseEntity<>(jobservice.modiferetat(id), HttpStatus.OK);
}
	@GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Job> getjobbyid(@PathVariable(value = "id")int id){
return new ResponseEntity<Job>(jobservice.getbyid(id),HttpStatus.ACCEPTED);
	}
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Job>getall(){
		return jobservice.getall();
	}
}
