package com.itechno.ecs.dao;

import com.itechno.ecs.entity.Admin;

public interface AdminDao {

	boolean loginAdmin(String username, String password);

	boolean updateAdmin(Admin admin);

}
