package com.pland.bootstrap.persistence.jpa.securityunit.test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.SequenceGenerator;


/**
 * Your application should create the EntityManagerFactory; 
 * the factory is thread-safe, and all code in your application that accesses 
 * the database should share it.
 * 
 * Refer to persistence.xml file
 *
 */




public class EntityManagerUtility {
	
	private static EntityManagerFactory emf;
	
	static{
		  emf = Persistence.createEntityManagerFactory("BootstrapSpringPU");
	}
	
	public static EntityManager getEntityManagerInstance(){
		EntityManager instance =  emf.createEntityManager();
		return instance;
	}

}
