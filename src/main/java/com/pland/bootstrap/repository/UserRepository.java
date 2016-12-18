package com.pland.bootstrap.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pland.bootstrap.persistence.jpa.securityunit.User;

@Repository
@Transactional
public class UserRepository {
	

	private EntityManager em;
	
	@Autowired
	public UserRepository(EntityManager em){
		this.em = em;
	}
	
	public User createAccount(User user){
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@ This is in UserService.java");
		try{
		
			em.getTransaction().begin();
			System.out.println("Firstname="+user.getFirstname());
			System.out.println("Lastname="+user.getLastname());
			System.out.println("Account="+user.getAccount());
			System.out.println("Password="+user.getPassword());
			System.out.println("email="+user.getEmail());
			
			em.persist(user);
			em.getTransaction().commit();

		}
		catch(Exception e){
			em.getTransaction().rollback();
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@ Exception in UserService.java");
			e.printStackTrace();

		}
		finally{
			em.close();
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@ em.close() Done in UserService.java");
			
		}
		
	    return user;
	}

}
