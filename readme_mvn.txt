################################################################################
This is referred to the book of "Twitter Bootstrap Web Development How-To" by David Cochran
1. You can get the digital book from Toronto Library
###############################################################################              
               
##################Create MVN Project from Scratch For this Project##############

1. Use MAVEN command to create a Maven Project
   mvn archetype:generate -DgroupId=com.pland -DartifactId=twitterbootstrap -DarchetypeArtifactId=maven-archetype-webapp -DinteractiveMode=false

2. Convert maven web project to eclipse web project
   cd twitterbootstrap
   mvn eclipse:eclipse -Dwtpversion=2.0   #######-Dwtpversion=2.0 it tells Maven to convert the project into an Eclipse web project (WAR), not the default Java project (JAR)

.......
3. Dependency is referred to "Spring In Action 4th Edition" By Craig Walls
   and in the Section of 1.3.1 Spring Module
                            
3. $> mvn clean package 
      (After running above command, maven dependency will appear in eclipse under the directory of Maven Dependecies, and war or jar file will be built; test cases also get executed)

4. Start Tomcat 8 Manually and put the war under its apps directory

5. Access the website
   http://localhost:8080/spittr-0.0.1-SNAPSHOT
   
###############################################################################


##################### MVN mostly used commands for a web project ###############

mvn clean package

############ MVN Dependency Analysis ############
mvn dependency::tree
mvn dependency:analyze
mvn dependency:analyze-dep-mgt

######Below commands don't run correctly due to plugins config in pom.xml######
mvn tomcat7:deploy
mvn tomcat7:undeploy
mvn tomcat7:run
mvn tomcat7:shutdown
     
################################################################################

#################Spring Web Initialization Process##############################


#################### Supprise You Service ###############################
1. A different way to test UI across different platforms
http://www.browserstack.com

2. Get ramdom pics in the size you want:
http://lorempixel.com/

3. Get Small Icons from Glyphicons
http://glyphicons.com/
http://www.w3schools.com/bootstrap/bootstrap_ref_comp_glyphs.asp

4. Color converter
http://www.javascripter.net/faq/rgbtohex.htm
You use Microsoft mspaint to pick up the big pen to pickup your color. It gives 
you the 3 digit number for each color (R,G,B). Then input them to above link get 
the Hex value. RGB->HEX

#################### Need more research on development######################### 

#==========================CSS Selector========================#
http://www.w3schools.com/cssref/css_selectors.asp

#==========Multiple class selector eg: .marketing .col-lg-4==============#
https://css-tricks.com/multiple-class-id-selectors/

BootStrap official site:
http://getbootstrap.com/
   
Good Links:
http://getbootstrap.com/
https://www.tutorialspoint.com/bootstrap/index.htm
http://htmldog.com/      




#======================================#
chrome://flags/
     
###############################################################################
