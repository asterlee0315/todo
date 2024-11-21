package com.ssafy.exam.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.exam.model.dao.DoctorDao;
import com.ssafy.exam.model.dto.Doctor;
import com.ssafy.exam.model.service.DoctorService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api")
public class DoctorRestController {
	private final DoctorService doctorService;
	
	public DoctorRestController(DoctorService doctorService) {
		this.doctorService=doctorService;
	}
	
	
	@PostMapping("/doctor")
	public ResponseEntity<String> addDoctor(@RequestBody Doctor doctor ) {
		boolean result = doctorService.addDoctor(doctor);
		if(result) {
			return new ResponseEntity<String>("Doctor added successfully", HttpStatus.CREATED);
		}
    	return new ResponseEntity<String>("Failed to add doctor", HttpStatus.NOT_IMPLEMENTED);

	}
	@GetMapping("/doctor")
	public ResponseEntity<List<Doctor>> getAllDoctors() {
		List<Doctor> list = doctorService.getAllDoctors();
		if(list!=null)
			{return new ResponseEntity<List<Doctor>>(list, HttpStatus.OK);
			}
		{
			return new ResponseEntity<List<Doctor>>(HttpStatus.NO_CONTENT);
		}
	}

	@GetMapping("/doctor/{id}")
	public ResponseEntity<Doctor> getDoctorById(@PathVariable int id ) {
		Doctor token = doctorService.getDoctorById(id);
		if(token!=null)
		return new ResponseEntity<Doctor>(token, HttpStatus.OK);
		{
			return new ResponseEntity<Doctor>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/doctor/{doctor}")
	public ResponseEntity<String> updateDoctor(@PathVariable int id, @RequestBody Doctor doctor) {
		boolean result = doctorService.updateDoctor(id, doctor);
		if(result) {
			return new ResponseEntity<String>("Doctor updated successfully", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Failed to update doctor", HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping("/doctor/{id}")
	public ResponseEntity<String> deleteDoctor(@PathVariable int id) {
		boolean result = doctorService.deleteDoctor(id);
		if(result) {
			return new ResponseEntity<String>("Doctor deleted successfully", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Failed to delete doctor", HttpStatus.BAD_REQUEST);
	}
}
