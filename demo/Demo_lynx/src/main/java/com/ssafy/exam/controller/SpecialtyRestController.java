package com.ssafy.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.exam.model.dto.Specialty;
import com.ssafy.exam.model.service.SpecialtyService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api")
@CrossOrigin()
public class SpecialtyRestController {
	
	private final SpecialtyService specialtyService;
	
	public SpecialtyRestController(SpecialtyService specialtyService) {
		this.specialtyService=specialtyService;
	}
	
	@PostMapping("/specialty")
    public ResponseEntity<String> addSpecialty(@RequestBody Specialty specialty) {
    	boolean result = specialtyService.addSpecialty(specialty);
    	if(result) {
    		return new ResponseEntity<String>("Specialty added successfully", HttpStatus.CREATED);    		
    	}
    	return new ResponseEntity<String>("Failed to add specialty", HttpStatus.NOT_IMPLEMENTED);
    }

	
	@GetMapping("/specialty/{code}")
    public ResponseEntity<Specialty> getSpecialty(@PathVariable int code) {
    	Specialty token = specialtyService.getSpecialtyByCode(code);
		if(token!=null)
    	return new ResponseEntity<Specialty>(token, HttpStatus.OK);
    
		{return new ResponseEntity<Specialty>(HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/specialty/{code}")
    public ResponseEntity<String> deleteSpecialty(@PathVariable int code) {
    	boolean result = specialtyService.deleteSpecialty(code);
    	if(result) {
    		return ResponseEntity.ok().body("Specialty deleted successfully");
    	}
    		return ResponseEntity.badRequest().body("Failed to delete specialty");
    }
}