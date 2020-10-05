package com.one.Shout.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.one.Shout.domain.Contactus;
import com.one.Shout.repository.ContactusRepo;

@RestController
@CrossOrigin
@RequestMapping("/rest")
public class ContactusController {

	@Autowired
	private ContactusRepo contactusRepo;
	
	
	@GetMapping(value="/contactus")
	public List<Contactus> getAll(){
		return contactusRepo.findAll();
	}
 	
	@PostMapping(value="/contactus")
	public ResponseEntity<String> addContact(@RequestBody Contactus contactus){
		contactusRepo.save(contactus);
		return ResponseEntity.ok("Thanks Foer Contacting Us!!!");
	}
	
}
