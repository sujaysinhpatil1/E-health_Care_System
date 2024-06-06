package com.itechno.ecs.service;

import java.util.List;

import com.itechno.ecs.entity.Admin;

public interface AdminService {
	
	Admin saveAdmin(Admin admin);
	boolean loginAdmin(String username, String password);
	boolean deleteAdminById(int id);
	Admin getAdminById(int id);
	List<Admin> getAdminByFirstName(String name);
	List<Admin> getAllAdmin();
	Admin updateAdmin(Admin admin);
	List<Admin> sortAdminById();
	List<Admin> sortAdminByFirstname();
	List<Admin> sortAdminByIdDesc();
	List<Admin> sortAdminByIdDescTop3();
	List<Admin> sortAdminByIdDescIgnoreTop3();
	
}
