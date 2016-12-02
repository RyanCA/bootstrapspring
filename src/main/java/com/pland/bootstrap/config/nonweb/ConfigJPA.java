package com.pland.bootstrap.config.nonweb;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

@Configuration
@ComponentScan(basePackages={"com.pland.bootstrap.repository"})
//@Profile("prod") This can be class level or method level, details refer to Spring in Action: 3.1.1. Configuring profile beans
public class ConfigJPA {
	
	
	/**
	 * 
	 * emf is a defined bean in ConfigJPA.java
	 * 
	 * @PersistenceUnit vs @Autowired
	 * They both should work but @PersistenceUnit allows you to specify which 
	 * specified persistence you can use(Not verfied yet)
	 */
//	@PersistenceUnit
	private EntityManagerFactory emf;
	
	@Autowired
	public void setEntityManagerFactory(EntityManagerFactory emf){
		this.emf = emf;
	}
	
	/**
	 * Initialize a bean, which will be used by class in domain package
	 * 
	 * LocalEntityManagerFactoryBean produces an application-managed EntityManagerFactory.
     * LocalContainerEntityManagerFactoryBean produces a container-managed EntityManagerFactory.
     * 
     * You can refer to book spring in action:
     * 11.2.1. Configuring an entity manager factory
     * 
	 */
	@Bean(name="emf")
	@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)//Singleton is default setting
	public LocalEntityManagerFactoryBean entityManagerFactoryBean() {
	  LocalEntityManagerFactoryBean emfb
	      = new LocalEntityManagerFactoryBean();
	  emfb.setPersistenceUnitName("BootstrapSpringPU");
	  return emfb;
	}
	
	@Bean(name="em")
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public EntityManager entityManagerBean() {
		EntityManager em = emf.createEntityManager();
	    return em;
	}
	
}
