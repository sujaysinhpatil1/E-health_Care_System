package com.itechno.ecs.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itechno.ecs.dao.AdminDao;
import com.itechno.ecs.entity.Admin;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminDao adminDao;

	@Override
	public boolean addAdmin(Admin admin) {
		return adminDao.addAdmin(admin);
	}

	@Override
	public boolean loginAdmin(String username, String password) {
		return adminDao.loginAdmin(username, password);
	}

	@Override
	public boolean deleteAdminById(int id) {
		return adminDao.deleteAdminById(id);
	}

	@Override
	public Admin getAdminById(int id) {
		return adminDao.getAdminById(id);
	}

	@Override
	public List<Admin> getAllAdmin() {
		List<Admin> adminList = adminDao.getAllAdmin();
		return adminList;
	}

	@Override
	public boolean updateAdmin(Admin admin) {
		boolean isUpdated = adminDao.updateAdmin(admin);
		return isUpdated;
	}

	@Override
	public List<Admin> sortAdminByFirstname() {
		List<Admin> adminList = adminDao.getAllAdmin();
		//Comparator<Integer> adminIdSort = (i1,i2)->i1.get
		List<Admin> sortedList = adminList.stream().sorted((p1, p2) -> (p1.getFirstname()).compareTo(p2.getFirstname())).collect(Collectors.toList());
		return sortedList;
	}

}
