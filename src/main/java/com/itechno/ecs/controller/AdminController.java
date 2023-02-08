package com.itechno.ecs.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itechno.ecs.dao.AdminDao;
import com.itechno.ecs.entity.Admin;
import com.itechno.ecs.exception.AdminNotFoundException;
import com.itechno.ecs.service.AdminService;

@RestController
public class AdminController {
	
	private static Logger LOG = LogManager.getLogger(AdminController.class);

	@Autowired
	private AdminDao adminDao;
	
	@Autowired
	private AdminService adminService;

	@PostMapping("/loginAdmin")
	public ResponseEntity<Boolean> loginAdmin(@RequestParam String username, @RequestParam String password) {
		LOG.info("Admin Login");
		boolean isPresent = adminService.loginAdmin(username, password);
		if (isPresent) {
			return new ResponseEntity<Boolean>(isPresent, HttpStatus.OK);
		} else {
			return new ResponseEntity<Boolean>(isPresent, HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/addAdmin")
	public ResponseEntity<Boolean> addAdmin(@Valid @RequestBody Admin admin) {
		LOG.info("Adding admin details");
		boolean isAdded = adminService.addAdmin(admin);
		if (isAdded) {
			return new ResponseEntity<Boolean>(isAdded, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Boolean>(isAdded, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getAdminById/{id}")
	public ResponseEntity<Admin> getAdminById(@PathVariable int id) {
		LOG.info("Fetching admin detail by his id");
		Admin admin = adminService.getAdminById(id);
		if (admin != null) {
			return new ResponseEntity<Admin>(admin, HttpStatus.OK);
		} else {
			throw new AdminNotFoundException("Admin not found for id : " + id);
		}
	}
	
	@PutMapping("/updateAdmin")
	public ResponseEntity<Boolean> updateAdmin(@RequestBody Admin admin){
		LOG.info("Updating admin details");
		boolean isUpdated = adminService.updateAdmin(admin);
		if(isUpdated) {
			return new ResponseEntity<Boolean>(isUpdated, HttpStatus.OK);
		}else {
			throw new AdminNotFoundException("Admin not found for update with id : " + admin.getId());
		}
	}
	
	@DeleteMapping(value = "/deleteAdminByID/{id}")
	public ResponseEntity<Boolean> deleteAdminByID(@PathVariable int id){
		LOG.info("Deleting admin details");
		boolean isDeleted = adminService.deleteAdminById(id);
		if(isDeleted) {
			return new ResponseEntity<Boolean>(isDeleted, HttpStatus.OK);
		}else {
			throw new AdminNotFoundException("Admin not found for id : " + id);
		}
	}
	
	@GetMapping(value = "/getAllAdmin")
	public ResponseEntity<List<Admin>> getAllAdmin(){
		List<Admin> adminList = adminService.getAllAdmin();
		if(!adminList.isEmpty()) {
			return new ResponseEntity<List<Admin>>(adminList, HttpStatus.OK);
		}else {
			throw new AdminNotFoundException("Admin list not found");
		}
	}
	
	@GetMapping(value = "/sortAdmin")
	public ResponseEntity<List<Admin>> sortAdmin(){
		List<Admin> sortedList = adminDao.sortAdmin();
		if(!sortedList.isEmpty()) {
			return new ResponseEntity<List<Admin>>(sortedList, HttpStatus.OK);
		}else {
			throw new AdminNotFoundException("Admin list not found");
		}
	}

}
