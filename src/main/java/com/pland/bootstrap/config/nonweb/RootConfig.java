package com.pland.bootstrap.config.nonweb;


import org.springframework.context.MessageSource;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * 
 * @Configuration indicates that the class can be used by the Spring IoC 
 * container as a source of bean definitions. 
 * The @Bean annotation tells Spring that a method annotated with @Bean will 
 * return an object that should be registered as a bean in the Spring 
 * application context
 * 
 * @Configuration is meta-annotated with @Component, therefore @Configuration 
 * classes are candidates for component scanning
 *
 * It will scan other Components, Configurations such as SecurityConfig.java
 */
@Configuration
@Import({ConfigJPA.class})
@ComponentScan(basePackages={"com.pland.bootstrap.config.nonweb"},
    excludeFilters={
        @Filter(type=FilterType.ANNOTATION, value=EnableWebMvc.class)
    })

public class RootConfig {
	

}
