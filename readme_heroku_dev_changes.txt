################################################################################
This is referred to the book of "Twitter Bootstrap Web Development How-To" by David Cochran
1. You can get the digital book from Toronto Library
###############################################################################  



###############################################################################
#                                                                             #
#                  Java Web Deployed on Heroku Tomcat                         #
#                                                                             #
###############################################################################

###### 1. Refercen link ######
https://devcenter.heroku.com/articles/java-webapp-runner#prerequisites

###### 2. Heroku Local Preparatio n######
1. Add tomcat plugin in pom.xml
2. $> mvn clean package
3. $> java -jar target/dependency/webapp-runner.jar target/bootstrap.war
4. http://localhost:8080                 # Note the url without appending /bootstrap in the end
5. $> git add                            # Add any files you added or updated
6. $> git commit -m "xxxxx"   
7. $> git push origin master

####### 3. Starting Heroku Related Process ######
8. $> heroku create bootstrapspring          # Please provide name otherwise will be random name
                                             # I used heroku create in the 1st time, so the name is secure-island-32273
                                             
Creating app... done, secure-island-32273
https://secure-island-32273.herokuapp.com/ | https://git.heroku.com/secure-island-32273.git

9. $> git remote -v                      # Code base is created in Heroku now
heroku  https://git.heroku.com/secure-island-32273.git (fetch)
heroku  https://git.heroku.com/secure-island-32273.git (push)
origin  https://github.com/RyanCA/bootstrapspring.git (fetch)
origin  https://github.com/RyanCA/bootstrapspring.git (push)
 
10. $> git push heroku master            # Push source to heroku and deploy it    
        
####### Reference of result ######
Counting objects: 95, done.
Delta compression using up to 4 threads.
Compressing objects: 100% (84/84), done.
Writing objects: 100% (95/95), 4.41 MiB | 869.00 KiB/s, done.
Total 95 (delta 14), reused 0 (delta 0)
remote: Compressing source files... done.
remote: Building source:
remote:
remote: -----> Java app detected
remote: -----> Installing OpenJDK 1.8... done
remote: -----> Installing Maven 3.3.9... done
remote: -----> Executing: mvn -B -DskipTests clean dependency:list install
remote:        [INFO] Scanning for projects...
remote:        [INFO] Downloading: https://repo.maven.apache.org/maven2/org/apac
......
......
......
remote:        [INFO] BUILD SUCCESS
remote:        [INFO] ------------------------------------------------------------------------
remote:        [INFO] Total time: 17.996 s
remote:        [INFO] Finished at: 2016-09-23T01:42:28+00:00
remote:        [INFO] Final Memory: 26M/185M
remote:        [INFO] ------------------------------------------------------------------------
remote: -----> Discovering process types
remote:        Procfile declares types -> web
remote:
remote: -----> Compressing...
remote:        Done: 103.1M
remote: -----> Launching...
remote:        Released v3
remote:        https://secure-island-32273.herokuapp.com/ deployed to Heroku  ######======Heroku link======######
remote:
remote: Verifying deploy.... done.
To https://git.heroku.com/secure-island-32273.git
 * [new branch]      master -> master

11. $> >heroku open                      #It will launch browser along with url
heroku-cli: Installing CLI... 18.18MB/18.18MB 
   

########################## Heroku Manual ######################################
https://devcenter.heroku.com/articles/getting-started-with-java#set-up

Install heroku Environment (install 03_heroku-toolbelt_HerokuOnly.exe)

###############################################################################

######################### Heroku Operations ###################################
1.
heroku login
    
2. 
git clone https://github.com/RyanCA/bootstrap.git

3.
cd bootstrap

4. create heroku project
$> heroku create                            # heroku create with system random name
or
$> heroku create bootstrap                  # heroku create app given name


5. If you want to remove this app
$> heroku apps:destroy -app secure-island-32273
###### Reference of Result Begin #######
 !    WARNING: This will delete secure-island-32273 including all
 !    add-ons.
 !    To proceed, type secure-island-32273 or re-run this
 !    command with --confirm secure-island-32273

secure-island-32273
Destroying secure-island-32273 (including all add-ons)... done
###### Reference of Result End #######

6. display heroku apps
$> heroku apps                             # heroku displays apps
carrental2015
secure-island-32273

7. use git push to put source code to heroku git and deploy app
(This will stop running apps, so you don't need to use command of "heroku ps:scale web=0" to stop app before deploy)
git push heroku master


8. Check app is deployed or not. Please check POM.XML and PROCFILE to see how we 
  can make web app runnable on heroku platform through heroku commands
heroku ps:scale web=1                   # Ensure that at least one instance of the app is running unless app crashed during the launch
heroku ps                               # check if any app is up
heroku logs                             # to see log if the server starts successfully

9. Now visit the app at the URL generated by its app name. As a handy shortcut, you can open the website as follows:
heroku open

################################################################################

###################### To be continued... ######################################
4.6 Heroku DB related
https://devcenter.heroku.com/articles/heroku-postgresql#provisioning-the-add-on

4.6.1 
heroku addons #to get all addons infomation including database)

Plan                         Name                Price
---------------------------  ------------------  -----
heroku-postgresql:hobby-dev  glowing-newly-5714  free

=== Attachments for carrental2015
Name      Add-on              Billing App
--------  ------------------  -------------
DATABASE  glowing-newly-5714  carrental2015

#If database is not there, please using below command to set it up.
4.6.1.1
heroku addons:create heroku-postgresql:hobby-dev

4.6.2 
heroku config #Check db url

=== carrental2015 Config Vars
DATABASE_URL: postgres://wmoemmlbtmyaob:Mzg3OijAltF2G6v0AWDqVrRUlt@ec2-54-83-17-
8.compute-1.amazonaws.com:5432/deghr853ufffo3
JAVA_OPTS:    -XX:+UseCompressedOops

4.6.3 check DB detail information
heroku pg:info

4.6.4 import data from Postgre dump file
https://devcenter.heroku.com/articles/heroku-postgres-import-export#import

heroku pg:psql #To run this command, Postgre DB must installed in local as pre-requisite

#######################################################################

