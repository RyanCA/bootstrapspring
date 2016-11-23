package com.pland.bootstrap.persistence.jpa.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import com.pland.bootstrap.persistence.jpa.User;

public class UserTest {
	
	@Test
	 public void testCreate() throws Exception {

       EntityManagerFactory emf =
           Persistence.createEntityManagerFactory("BootstrapSpringPU");

       try {

               EntityManager em = emf.createEntityManager();
               em.getTransaction().begin();

               User user = new User();
               user.setAccount("ryan");
               user.setPassword("123456");
               user.setFirstname("ryan");
               user.setLastname("Test");
               user.setActive(true);
               user.setEmail("ryan@gmail.com");

               em.persist(user);

               em.getTransaction().commit();


       } finally {
           emf.close();
       }
   }

}
