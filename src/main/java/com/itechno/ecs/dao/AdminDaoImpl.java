package com.itechno.ecs.dao;

import java.util.List;
import java.util.Optional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itechno.ecs.entity.Admin;

@Repository
public class AdminDaoImpl implements AdminDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean addAdmin(Admin admin) {
		Session session = null;
		boolean isAdded = false;
		try {
			session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(admin);
			transaction.commit();
			isAdded = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return isAdded;
	}

	@Override
	public boolean loginAdmin(String username, String password) {
		Session session = null;
		boolean isPresent = false;
		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Admin.class);
			Criterion name = Restrictions.eq("username", username);
			Criterion pass = Restrictions.eq("password", password);
			criteria.add(Restrictions.and(name, pass));
			Admin admin = (Admin) criteria.uniqueResult();
			if (admin != null) {
				isPresent = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return isPresent;
	}

	@Override
	public boolean deleteAdminById(int id) {
		Session session = null;
		Transaction transaction = null;
		boolean isDeleted = false;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Admin adm = session.get(Admin.class, id);
			if (adm != null) {
				session.delete(adm);
				transaction.commit();
				isDeleted = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return isDeleted;
	}

	@Override
	public Admin getAdminById(int id) {
//		Session session = null;
//		Admin admin = null;
//		try {
//			session = sessionFactory.openSession();
//			admin = session.get(Admin.class, id);
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			if (session != null) {
//				session.close();
//			}
//		}
//		return admin;
		return null;
	}

	@Override
	public List<Admin> getAllAdmin() {
		
		return null;
	}

	@Override
	public boolean updateAdmin(Admin admin) {
		Session session = null;
		Transaction transaction = null;
		boolean isUpdated = false;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Admin adm = session.get(Admin.class, admin.getId());
			if (adm != null) {
				session.evict(adm);
				session.save(admin);
				transaction.commit();
				isUpdated = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return isUpdated;
	}
	
	@Override
	public List<Admin> sortAdmin() {
		return null;
	}

	@Override
	public <S extends Admin> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Admin> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Admin> findById(Integer id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Admin> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Admin> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Admin entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends Admin> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

}
