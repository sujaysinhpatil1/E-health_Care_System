package com.itechno.ecs;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.itechno.ecs.dao.AdminDao;
import com.itechno.ecs.entity.Admin;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class EHealthCareSystemApplicationTests {
	
	@Autowired
	private AdminDao adminDao;
	
	
	// API testing
	// append method written in controller with Test word
//	@Test
//	@Order(1)
//	public void getAdminByIdTest() throws URISyntaxException {
//
//		System.out.println("Test started");
//		RestTemplate restTemplate = new RestTemplate();
//		String url = "http://localhost:8080/getAdminById/1";   		// url can be created dynamically
//		URI uri = new URI(url);
//		ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
//		Assertions.assertEquals(200, response.getStatusCodeValue());  // HTTP status code --> success or fail
//		System.out.println(response.getStatusCode());
//		System.out.println("Test ended");
//
//	}
	
//	@Test
//	@Order(2)
//	public void deleteAdminByIdTest() throws URISyntaxException {
//
//		System.out.println("Test started");
//		RestTemplate restTemplate = new RestTemplate();
//		String url = "http://localhost:8080/deleteAdminByID/1";   		// url can be created dynamically
//		URI uri = new URI(url);
//		ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
//		Assertions.assertEquals(200, response.getStatusCodeValue());  // HTTP status code --> success or fail
//		System.out.println(response.getStatusCode());
//		System.out.println("Test ended");
//
//	}
	
	@Test
	@Order(1)
	public void testCreate() {
		Admin admin = new Admin();
		//admin.setId(1);
		admin.setFirstname("Sujaysinh");
		admin.setLastname("Patil");
		admin.setUsername("sujay");
		admin.setPassword("1234");
		admin.setMobileno("12345678");
		admin.setCity("Pune");
		admin.setPincode("123456");
		adminDao.addAdmin(admin);
		assertNotNull(adminDao.getAdminById(1));
	}

//	@Test
//	@Order(2)
//	public void testUpdate() {
//		Admin admin = adminDao.getAdminById(1);
//		admin.setCity("Mumbai");
//		adminDao.deleteAdminById(1);
//		adminDao.addAdmin(admin);
//		assertNotEquals("Pune", adminDao.getAdminById(2).getCity());
//	}
//	
//	@Test
//	@Order(3)
//	public void testSingleAdmin() {
//		Admin admin = adminDao.getAdminById(2);
//		assertEquals("Sujaysinh", admin.getFirstname());
//	}
//	
//	@Test
//	@Order(4)
//	public void testDelete() {
//		boolean isDeleted = adminDao.deleteAdminById(2);
//		assertThat(isDeleted).isTrue();
//	}

}
