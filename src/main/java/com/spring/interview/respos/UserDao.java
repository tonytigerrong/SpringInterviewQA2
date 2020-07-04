package com.spring.interview.respos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.interview.models.User;
import com.spring.interview.services.SecurityServiceImpl;

@Repository
public class UserDao {
	@Autowired
	private SessionFactory sessionFactory;
	private static final Logger logger = LoggerFactory.getLogger(SecurityServiceImpl.class);

	public Integer createUser(User user) {
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			Integer id = ((Long)session.save(user)).intValue();
			logger.debug(String.format("Save User %s successfully!", id));
			session.getTransaction().commit();
			return id;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
