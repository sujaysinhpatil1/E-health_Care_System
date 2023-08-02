package com.itechno.ecs.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

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

	@GetMapping("/loginAdmin/{username}/{password}")
	public ResponseEntity<Boolean> loginAdmin(@PathVariable String username, @PathVariable String password) {
		LOG.info("Admin Login");
		boolean isPresent = adminService.loginAdmin(username, password);
		if (isPresent) {
			return new ResponseEntity<Boolean>(isPresent, HttpStatus.OK);
		} else {
			return new ResponseEntity<Boolean>(isPresent, HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/saveAdmin")
	public ResponseEntity<Admin> saveAdmin(@Valid @RequestBody Admin admin) {
		Admin isSaved = adminService.saveAdmin(admin);
		if (isSaved != null) {
			return new ResponseEntity<Admin>(isSaved, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Admin>(isSaved, HttpStatus.INTERNAL_SERVER_ERROR);
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
	public ResponseEntity<Admin> updateAdmin(@RequestBody Admin admin) {
		LOG.info("Updating admin details");
		Admin isUpdated = adminService.updateAdmin(admin);
		if (isUpdated != null) {
			return new ResponseEntity<Admin>(isUpdated, HttpStatus.OK);
		} else {
			throw new AdminNotFoundException("Admin not found for update with id : " + admin.getId());
		}
	}

	@DeleteMapping(value = "/deleteAdminByID/{id}")
	public ResponseEntity<Boolean> deleteAdminByID(@PathVariable int id) {
		LOG.info("Deleting admin details");
		boolean isDeleted = adminService.deleteAdminById(id);
		if (isDeleted) {
			return new ResponseEntity<Boolean>(isDeleted, HttpStatus.OK);
		} else {
			throw new AdminNotFoundException("Admin not found for id : " + id);
		}
	}

	@GetMapping(value = "/getAllAdmin")
	public ResponseEntity<List<Admin>> getAllAdmin() {
		List<Admin> adminList = adminService.getAllAdmin();
		// List<Admin> adminList = null; // NullPointerException --> 500 (Internal Server Error)
		if (!adminList.isEmpty()) {
			return new ResponseEntity<List<Admin>>(adminList, HttpStatus.OK);
		} else {
			throw new AdminNotFoundException("Admin list not found");
		}
	}

	@GetMapping(value = "/sortAdmin")
	public ResponseEntity<List<Admin>> sortAdmin() {
		List<Admin> sortedList = adminDao.sortAdmin();
		if (!sortedList.isEmpty()) {
			return new ResponseEntity<List<Admin>>(sortedList, HttpStatus.OK);
		} else {
			throw new AdminNotFoundException("Admin list not found");
		}
	}

	@GetMapping(value = "/sortAdminByFirstname")
	public ResponseEntity<List<Admin>> sortAdminByFirstname() {
		List<Admin> sortedList = adminService.sortAdminByFirstname();
		if (!sortedList.isEmpty()) {
			return new ResponseEntity<List<Admin>>(sortedList, HttpStatus.OK);
		} else {
			throw new AdminNotFoundException("Admin list not found");
		}
	}

	@GetMapping(value = "/sortAdminByFirstnameWithCount")
	public ResponseEntity<Map<String, Set<Admin>>> sortAdminByFirstnameWithCount() {
		List<Admin> list = adminDao.getAllAdmin();

		Map<String, Set<Admin>> sortedMap = list.stream()
				.collect(Collectors.groupingBy(a -> a.getFirstname(), Collectors.toSet()));

		if (!sortedMap.isEmpty()) {
			return new ResponseEntity<Map<String, Set<Admin>>>(sortedMap, HttpStatus.OK);
		} else {
			throw new AdminNotFoundException("Admin list not found");
		}
	}

	@GetMapping(value = "/sortAdminByIdDesc")
	public ResponseEntity<List<Admin>> sortAdminByIdDesc() {
		List<Admin> sortedList = adminService.sortAdminByIdDesc();

		if (!sortedList.isEmpty()) {
			return new ResponseEntity<List<Admin>>(sortedList, HttpStatus.OK);
		} else {
			throw new AdminNotFoundException("Admin list not found");
		}
	}

	@GetMapping(value = "/sortAdminByIdDescTop3")
	public ResponseEntity<List<Admin>> sortAdminByIdDescTop3() {
		List<Admin> sortedList = adminService.sortAdminByIdDescTop3();

		if (!sortedList.isEmpty()) {
			return new ResponseEntity<List<Admin>>(sortedList, HttpStatus.OK);
		} else {
			throw new AdminNotFoundException("Admin list not found");
		}
	}

	@GetMapping(value = "/sortAdminByIdDescIgnoreTop3")
	public ResponseEntity<List<Admin>> sortAdminByIdDescIgnoreTop3() {
		List<Admin> sortedList = adminService.sortAdminByIdDescIgnoreTop3();

		if (!sortedList.isEmpty()) {
			return new ResponseEntity<List<Admin>>(sortedList, HttpStatus.OK);
		} else {
			throw new AdminNotFoundException("Admin list not found");
		}
	}

}
