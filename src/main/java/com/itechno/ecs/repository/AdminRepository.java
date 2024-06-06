package com.itechno.ecs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.itechno.ecs.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

//	Admin addAdmin(Admin admin);

//	List<Admin> sortAdminById();

	// @Query("select a from Admin a where a.id=:ids")
	// Admin getAdminById(@Param("ids") int id);

	@Query(value = "select*from Admin;", nativeQuery = true)
	List<Admin> getAllAdmin();

	@Query("select a from Admin a order by a.mobileno")
	List<Admin> sortAdminByMobileNo();

	@Query("select a from Admin a where a.firstname= : n")
	List<Admin> getAdminByFirstName(@Param("n") String name);

}
