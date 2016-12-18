################################################################################
This is referred to  book of "Twitter Bootstrap Web Development How-To" by David Cochran
It also is referred to book of "Java Persistence with Hibernate, second Edition"
1. You can get the digital book from Toronto Library
###############################################################################              
 


################################################################################
###################            Big Questions            ########################
################################################################################
1. What hibernate about? 
A: It's about OR mapping. Beyond that, you need to know how to map from OO object
   to relational database; 
   
   In which situations, define @Entity Class; in which ones, define a value type; 
   and in which ones, define @Embeddable;
   Quote from 7.3.2: 
      Ask yourself if any table in the schema will have a BID_ID foreign key 
      column. If not, map the Bid class as @Embeddable, not @Entity
      
   how inheritance get mapped to DB; 
   
   how parent-child associations get mapped to DB;
    
   how entity associations get mapped to DB(OneToOne; OneToMany; ManyToOne and ManyToMany mapping);
   
   what is the difference between parent-child association and entity association?
   (The key is parent-child association life cycle is dependent on the owning 
   Entity, while for entity association such as OneToMany, the life cycles not 
   dependent on owning entity)
   
2. How to design a database?
   first build up your domain model from business model, then from domain model, 
   you build your data model


1. What is Spring in 30 seconds?
   DI: 1. @Configuration, @ComponentScan, @Component and @Autowired work together 
          for automatic spring configuration;
          
       2. 2.3.2 Declaring a simple bean(It applies for autowiring components from 3rd party, we don't own the source)
          @Configuration, @Bean and @Autowired is another way for spring configuration.
          By default, all beans in Spring are singletons;
          
    @Autowired used to annotated fields, contructors and methods, what is the difference?
          


################################################################################
###################            Detail Questions            #####################
################################################################################
01. Hibernate will refresh your database, drop and create tables for each test class
A: This is because you create EntityManagerFactory for each test class. They all
   should share only one EntityManagerFactory.

02. How to make your @Entity works? 
    1. Define @Entity class first;
    2. Put the class definition in persistence.xml to ensure hibernate JPA will 
       Know them. And you can define if create schema by mapping Entity to DB
   
03. Is there any conflicts to define TL_GroupMembers in both Group.java and GroupMembers.java?

04. ManyToOne is enough to define a foreign key, OneToMany from the otherside is
    not necessary.
    Quote 7.3.1:
    when you see a foreign key column and two entity classes involved, you 
    should probably map it with @ManyToOne and nothing else. 

05. A java class should be mapped as Entity or Embedable?
    If the id of the class will not be used as foreign key for other tables, then
    map this class as Embedable otherwise as entity.
    Quote from 7.3.2: 
    Ask yourself if any table in the schema will have a BID_ID foreign key 
    column. If not, map the Bid class as @Embeddable, not @Entity
    
    OneToMany and ManyToOne with Cascading and Transitive, refer to 7.3.2 and 7.3.3
    OneToMany with Cascade option use often, but ManyToOne with Cascade option 
    use less often.
    cascade = CascadeType.PERSISTENT
    cascade = CascadeType.REMOVE, which is not efficient compared to one single 
    statement to delete all. (Listing 7.19. Cascading removal from Item to all bids)
    Or you can define OnDelete Cascade when defining schema (Listing 7.22. Generating foreign key ON DELETE CASCADE in the schema)
    
    List 7.18 ??? persist still works for entity associations after persist();
    em.persist(someitem);someitem.getBids().add(someBid);tx.commit();
    
    Listing 7.21. Hibernate doesn’t clean up in-memory references after database removal
    Orphan removal may cause issues in shared references. Solution is to make mapping
    relationship simple
    
    OneToOne Mapping refer to "8.1.3. Using a foreign key join column"
    
06. Link on header will automatically add "user" as part of its URL path
    Original code:
    <li><a href="user/signup"><span class="glyphicon glyphicon-user"></span> Sign Up </a></li>
    <li><a href="user/signin"><span class="glyphicon glyphicon-log-in"></span> Sign In </a></li>

    Question description:
	1. URL: http://localhost:8080/bootstrap/
	   The link on "signup" is http://localhost:8080/bootstrap/user/signup
	2. After click on link in step 1, 
	   URL changed to: http://localhost:8080/bootstrap/user/signup
	   The link on "signup" is http://localhost:8080/bootstrap/user/user/signup

	Solution: 
	Put the href in absolute address format by puting it as following begin with "/", which is successful
	<li><a href=<s:url value="/user/signup" />  ><span class="glyphicon glyphicon-user"></span> Sign Up </a></li>
	
	I tried another solution as following, which will cause URL as http://localhost:8080/user/signup (losing the domain of bootstrap)
	<li><a href="user/signup"><span class="glyphicon glyphicon-log-in"></span> Sign In </a></li>		
	
07. 18-Dec-2016 16:56:31.462 SEVERE [localhost-startStop-2] org.apache.catalina.loader.WebappClassLoader.clearReferencesJdbc The web application [/bootstrap] registered the JDBC driver [org.h2.Driver] but failed to unregister it when the web application was stopped. To prevent a memory leak, the JDBC Driver has been forcibly unregistered.
    18-Dec-2016 16:56:31.462 SEVERE [localhost-startStop-2] org.apache.catalina.loader.WebappClassLoader.clearReferencesThreads The web application [/bootstrap] appears to have started a thread named [pool-1-thread-1] but has failed to stop it. This is very likely to create a memory leak.

    
    Solution:
    http://stackoverflow.com/questions/3320400/to-prevent-a-memory-leak-the-jdbc-driver-has-been-forcibly-unregistered
    
    																																						



    
    