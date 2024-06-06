package com.itechno.ecs.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itechno.ecs.dao.AdminDao;
import com.itechno.ecs.entity.Admin;
import com.itechno.ecs.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao adminDao;

	@Autowired
	private AdminRepository adminRepository;

	@Override
	public Admin saveAdmin(Admin admin) {
		return adminRepository.save(admin);
	}

	@Override
	public boolean loginAdmin(String username, String password) {
		return adminDao.loginAdmin(username, password);
	}

	@Override
	public boolean deleteAdminById(int id) {
		Admin isPresent = getAdminById(id);
		boolean isDeleted = false;
		if (isPresent != null) {
			adminRepository.deleteById(id);
			isDeleted = true;
		}
		return isDeleted;
	}

	@Override
	public Admin getAdminById(int id) {
		Optional<Admin> opt = adminRepository.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		} else {
			return null;
		}
	}

	@Override
	public List<Admin> getAdminByFirstName(String name) {
		List<Admin> adminList = adminRepository.getAdminByFirstName(name);
		return adminList;
	}

	@Override
	public List<Admin> getAllAdmin() {
		return adminRepository.findAll();
	}

	@Override
	public Admin updateAdmin(Admin admin) {
		return adminRepository.save(admin);
	}

	@Override
	public List<Admin> sortAdminById() {
		List<Admin> adminList = adminRepository.findAll().stream().sorted((i1, i2) -> (i1.getId() - i2.getId()))
				.collect(Collectors.toList());
		return adminList;
	}

	@Override
	public List<Admin> sortAdminByFirstname() {
		List<Admin> adminList = adminRepository.getAllAdmin();
		// Comparator<Integer> adminIdSort = (i1,i2)->i1.get
		List<Admin> sortedList = adminList.stream().sorted((p1, p2) -> (p1.getFirstname()).compareTo(p2.getFirstname()))
				.collect(Collectors.toList());
		return sortedList;
	}

	@Override
	public List<Admin> sortAdminByIdDesc() {
		List<Admin> adminList = adminRepository.getAllAdmin();
		List<Admin> sortedList = adminList.stream().sorted((i1, i2) -> (i2.getId() - i1.getId()))
				.collect(Collectors.toList());
		return sortedList;
	}

	@Override
	public List<Admin> sortAdminByIdDescTop3() {
		List<Admin> adminList = adminRepository.getAllAdmin();
		List<Admin> sortedList = adminList.stream().sorted((i1, i2) -> (i2.getId() - i1.getId())).limit(3)
				.collect(Collectors.toList());
		return sortedList;
	}

	@Override
	public List<Admin> sortAdminByIdDescIgnoreTop3() {
		List<Admin> adminList = adminRepository.getAllAdmin();
		List<Admin> sortedList = adminList.stream().sorted((i1, i2) -> (i2.getId() - i1.getId())).skip(3)
				.collect(Collectors.toList());
		return sortedList;
	}

}