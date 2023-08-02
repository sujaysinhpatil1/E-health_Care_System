package com.itechno.ecs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.itechno.ecs.dao.DoctorDao;
import com.itechno.ecs.entity.Doctor;
import com.itechno.ecs.exception.AdminNotFoundException;

@RestController
public class DoctorController {
	
	@Autowired
	private DoctorDao doctorDao;
	
	@PostMapping(value = "/addDoctor")
	public ResponseEntity<Boolean> addDoctor(@RequestBody Doctor doctor){
		
		boolean isAdded = doctorDao.addDoctor(doctor);
		if(isAdded) {
			return new ResponseEntity<Boolean>(isAdded, HttpStatus.CREATED);
		}else {
			return new ResponseEntity<Boolean>(isAdded, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping(value = "/getDoctorById/{Id}")
	public ResponseEntity<Doctor> getDoctorById(@PathVariable int doctorid){
		
		Doctor doctor = doctorDao.getDoctorById(doctorid);
		if(doctor != null) {
			return new ResponseEntity<Doctor>(doctor, HttpStatus.CREATED);
		}else {
			throw new AdminNotFoundException("Doctor not found for id : " + doctorid);
		}
		
	}

}
