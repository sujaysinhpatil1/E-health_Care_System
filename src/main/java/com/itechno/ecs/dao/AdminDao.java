package com.itechno.ecs.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.itechno.ecs.entity.Admin;

public interface AdminDao extends CrudRepository<Admin, Integer>{
	
	boolean addAdmin(Admin admin);
	boolean loginAdmin(String username, String password);
	boolean deleteAdminById(int id);
	boolean updateAdmin(Admin admin);

	@Query("select a from Admin a where a.id=:ids")
	Admin getAdminById(@Param("ids") int id);
	
	@Query(value = "select*from Admin;", nativeQuery = true)
	List<Admin> getAllAdmin();
	
	@Query("select a from Admin a order by a.firstname")
	List<Admin> sortAdmin();
	
}
