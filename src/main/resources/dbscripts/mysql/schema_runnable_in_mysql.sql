
--------------------------------------------------------
-- ###############################################################
-- ######This is the all in one script, can be run in MySQL ######
-- ###############################################################
-- MySQL Schema Script
-- MySQL Server 5.6.31
-- MySQL Workbench (6.3.7 CE) Forward Engineering
-- -----------------------------------------------------
-- Schema test
-- Tables starting with TL_ can be easily indentified as my application tables
-- in DB if there are other applications in the same DB.

-- Test tables
drop table if exists TL_TEST_MESSAGE;

-- Business tables
drop table if exists TL_USER_CONNECTIONS;
drop table if exists TL_TWITTER_FAVORITES;
drop table if exists TL_TWITTER;

-- Security tables
drop table if exists TL_GROUP_MEMBERS;
drop table if exists TL_GROUP_PERMISSIONS;
drop table if exists TL_PERMISSION;
drop table if exists TL_GROUP;
drop table if exists TL_USER;
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Table TL_TESTS_MESSAGE
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS TL_TEST_MESSAGE (
  id INT NOT NULL,
  message VARCHAR(120) NOT NULL,
  CONSTRAINT tl_test_message_pk PRIMARY KEY (id)
);

-- -----------------------------------------------------
-- Table TL_USER
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS TL_USER (
  id INT NOT NULL,
  account VARCHAR(45) NOT NULL,
  password VARCHAR(90) NOT NULL,
  firstname VARCHAR(45) NOT NULL,
  lastname VARCHAR(45) NOT NULL,
  email VARCHAR(45) NOT NULL,
  emailverified BOOLEAN,
  cellphone VARCHAR(45) NOT NULL,
  accountactive BOOLEAN NULL,
  createdatetime TIMESTAMP NOT NULL,
  updatedatetime TIMESTAMP NULL,
  CONSTRAINT tl_user_pk PRIMARY KEY (id),
  INDEX tl_user_index_acct_createtime (account, createdatetime)
);

-- CREATE INDEX tl_users_account_createdatetime on TL_USERS(account, createdatetime); -- For searching by username
-- DROP INDEX tl_users_account_createdatetime on TL_USERS;

-- -----------------------------------------------------
-- Table TL_GROUP
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS TL_GROUP (
  id INT NOT NULL,
  name VARCHAR(45) NULL,
  active BOOLEAN NULL,
  createdatetime DATETIME NULL,
  updatedatetime DATETIME NULL,
  CONSTRAINT tl_group_pk PRIMARY KEY (id));

-- -----------------------------------------------------
-- Table TL_GROUP_MEMBERS
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS TL_GROUP_MEMBERS (
  id INT NOT NULL,
  group_id INT NULL,
  user_id INT NULL,
  active BOOLEAN NULL,
  createdatetime DATETIME NULL,
  updatedatetime DATETIME NULL,
  CONSTRAINT tl_group_members_pk PRIMARY KEY (id),
  CONSTRAINT tl_group_members_fk_groupid FOREIGN KEY (group_id) REFERENCES TL_GROUP (id),
  CONSTRAINT tl_group_members_fk_userid FOREIGN KEY (user_id) REFERENCES TL_USER (id));

-- -----------------------------------------------------
-- Table TL_PERMISSION
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS TL_PERMISSION (
  id INT NOT NULL,
  rolename VARCHAR(45) NULL,
  active BOOLEAN NULL,
  createdatetime DATETIME NULL,
  updatedatetime DATETIME NULL,
  CONSTRAINT tl_permission_pk PRIMARY KEY (id));

-- -----------------------------------------------------
-- Table TL_GROUP_PERMISSIONS
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS TL_GROUP_PERMISSIONS (
  id INT NOT NULL,
  group_id INT NULL,
  permission_id INT NULL,
  active BOOLEAN NULL,
  createdatetime DATETIME NULL,
  updatedatetime DATETIME NULL,
  CONSTRAINT tl_group_permissions_pk PRIMARY KEY (id),
  CONSTRAINT tl_group_permissions_fk_groups_id FOREIGN KEY (group_id) REFERENCES TL_GROUP (id),
  CONSTRAINT tl_group_permissions_fk_permissions_id FOREIGN KEY (permission_id) REFERENCES TL_PERMISSION (id));

-- -----------------------------------------------------
-- Table TL_TWITTER
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS TL_TWITTER (
  id INT NOT NULL,
  user_id INT NOT NULL,
  text_content VARCHAR(140) NULL,
  deleteflag BOOLEAN NULL,
  createdatetime DATETIME NULL,
  updatedatetime DATETIME NULL,
  PRIMARY KEY (id),
  INDEX TL_TWITTER_users_id_fk_idx (user_id ASC),-- For searching twitters by username and createdatetime
  CONSTRAINT TL_TWITTER_user_id_fk FOREIGN KEY (user_id) REFERENCES TL_USER (id));


-- -----------------------------------------------------
-- Table TL_USER_CONNECTIONS
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS TL_USER_CONNECTIONS (
  id BIGINT NOT NULL,
  user_id_followee INT NOT NULL,
  user_id_followers INT NOT NULL,
  createdatetime DATETIME NULL,
  updatedatetime DATETIME NULL,
  PRIMARY KEY (id),
  INDEX TL_USERS_CONNECTIONS_user_id_fk_idx (user_id_followee ASC),
  INDEX TL_USERS_CONNECTIONS_followee_id_fk_idx (user_id_followers ASC),
  CONSTRAINT TL_USERS_CONNECTIONS_user_id_fk
    FOREIGN KEY (user_id_followee)
    REFERENCES TL_USER (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT TL_USER_CONNECTIONS_follower_id_fk
    FOREIGN KEY (user_id_followers)
    REFERENCES TL_USER (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table TL_TWITTER_FAVORITES
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS TL_TWITTER_FAVORITES (
  id INT NOT NULL,
  twitter_id INT NULL,
  user_id INT NULL,
  createdatetime DATETIME NULL,
  updatedatetime DATETIME NULL,
  INDEX TL_TWITTERS_FAVORITES_twitter_id_fk_idx (twitter_id ASC),
  INDEX TL_TWITTERS_FAVORITES_user_id_fk_idx (user_id ASC),
  CONSTRAINT TL_TWITTERS_FAVORITES_twitter_id_fk
    FOREIGN KEY (twitter_id)
    REFERENCES TL_TWITTER (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT TL_TWITTER_FAVORITES_user_id_fk
    FOREIGN KEY (user_id)
    REFERENCES TL_USER (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;