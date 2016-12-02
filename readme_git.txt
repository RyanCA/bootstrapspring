################################################################################
This is referred to  book of "Twitter Bootstrap Web Development How-To" by David Cochran
It also is referred to book of "Java Persistence with Hibernate, second Edition"
1. You can get the digital book from Toronto Library
###############################################################################              
 
###############################################################################
###                                                                         ###
### If you have 2-factor Authentication enabled you will need to create an  ### 
### application specific password to push your repo.                        ###
###                                                                         ###
###############################################################################
Refer to following URL to setup it:
https://help.github.com/articles/creating-an-access-token-for-command-line-use/


###############################################################################
###                                                                         ###
###                     Git command reference                               ### 
###                  https://git-scm.com/book/en/v2                         ###
###                                                                         ###
###############################################################################
  

############################## Git Repository Location #########################
https://github.com/RyanCA

############################## Git Manual ######################################
https://git-scm.com/book/en/v2

############################## If project in Git ##############################
git clone https://github.com/RyanCA/bootstrapspring.git

######################## A: If a project in local already ######################

1. Refer to "Create MVN Project from Scratch For this Project" in readme_mvn.txt to 
create the project and develop it

2. Use git commands below to push resources into git
 
cd ......\eclipse_projects
git init bootstrapspring # .git directory created in local
cd .\bootstrapspring
git add .                         # Add all resources from UNTRACKED To TRACKED
git status                        # Check resources info before commit
git commit -m "Init commit batch" # resources updated from TRACKED to STATGED
git push origin master
 
################################################################################
B: If no repository for your project on Github, then you need do following steps
################################################################################
2.1 create a repo on github through github web UI

2.2 copy the url of new repo and use below commands to associate local and git server 
git init bootstrapspring # .git directory created in local
git remote add origin https://github.com/RyanCA/bootstrapspring.git
git remote -v                     # Check if add remote successfully or not
origin  https://github.com/RyanCA/bootstrapspring.git (fetch)
origin  https://github.com/RyanCA/bootstrapspring.git (push)

################################################################################

################################# Git Notes ####################################
1. Once the repo created on Github, the name can't changed but the project name on eclipse can be changed.
   Eg: the project name is called J01_Spring, later on I changed it to springinaction4thedition to keep it consistent with repo name

############################### Git Tag ########################################
git tag -a v0.1 -m 'Simple Spring MVC with Maven and Eclipse'
git tag
git push origin v0.1              # Push tags into git server

git tag                           # List all tags
git show -v0.1                    # Show specific Tag

#Checkout a specific tag (Page 78 of progit-en.1084.pdf or https://git-scm.com/book/en/v2)
git clone  https://github.com/RyanCA/springinaction4thedition.git
cd springinaction4thedition
git show v0.2                     # Spring MVC, Spring Security and Spring Exception Handling Done
git checkout -b springmvc v0.2    # -b [branch name] [tag name]
git status                        # Show on springmvc branch now

################################################################################

##############################Git Tag History##################################
Branch         Tag      Description
heroku_local            For heroku development
master         v0.2     Spring MVC, Spring Security and Spring Exception Handling Done


################################################################################

############################# Git Reverse rm Action ############################
# Refer to page 57 of progit-en.1084.pdf or https://git-scm.com/book/en/v2
git rm readme_mvn_startup.txt     #This will delete a file, if you don't want to delete it, you can do the following to get it back
git reset HEAD readme_mvn_startup.txt
git checkout readme_mvn_startup.txt

####################### To Be Continued... #####################################

git log
git log --oneline or --decorate or --graph or --all
git diff 
git remote -v
git remote add <shortname> <url>
git remote add pb https://github.com/paulboone/ticgit

git fetch pb
git pull
git clone
git remote show origin
git push

git remote rename name1 name2
git remote rm name

# Refer to page 90 of progit-en.1084.pdf or https://git-scm.com/book/en/v2  
git branch xxx
git checkout xxx

#Branch related
git checkout -b heroku_local
git status
git add ...
git put origin heroku_local

