package com.itechno.ecs.service;

import java.util.List;

import com.itechno.ecs.entity.Admin;

public interface AdminService {
	
	boolean addAdmin(Admin admin);
	boolean loginAdmin(String username, String password);
	boolean deleteAdminById(int id);
	Admin getAdminById(int id);
	List<Admin> getAllAdmin();
	boolean updateAdmin(Admin admin);
	List<Admin> sortAdminById();
	
}
