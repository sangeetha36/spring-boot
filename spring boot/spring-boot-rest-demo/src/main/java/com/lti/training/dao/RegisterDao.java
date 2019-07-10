package com.lti.training.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.training.entity.User;

@Repository
public class RegisterDao {

	@PersistenceContext
	private EntityManager em;
	
	
	public int save(User user) {
		User u=em.merge(user);
	    return u.getId();
	}
	
	public User fetch(String email) {
		return (User) em.createQuery("select u from User u where u.email = :eml").setParameter("eml", email).getSingleResult();
	}

}
