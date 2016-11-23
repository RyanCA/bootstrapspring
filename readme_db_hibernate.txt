
##############################################################
#   Please refer to Commands_DB_MySQL for more details       #
#   How to start MySQL DB Environment                        #
##############################################################

1. start MySQL DB server
> mysqld.exe

2. start MySQL workbench
> MySQLWorkbench.exe

3. run your following script in MySQL to create tables
   src\main\resources\dbscripts\mysql\schema_runnable_in_mysql.sql

4. or you can use below command line to connect DB
mysql -h localhost -u root  -p
 >show databases;
 >use test; #One of database
 >show tables;
 
###############################################################
#            How to start Hibernate JPA coding                #
#                                                             #
###############################################################

1. Add the necessary hibernate JPA jar files in pom.xml file;
2. create src\main\resources\META-INF\persistence.xml;
3. create entity class, please refer to src\main\java\com\pland\bootstrap\persistence\jpa\Message.java
4. write test code, please refer to src\test\java\com\pland\bootstrap\persistence\jpa\test\MessageTest.java
