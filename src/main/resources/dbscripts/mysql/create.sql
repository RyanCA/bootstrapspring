
--------------------------------------------------------
--###################################################################
--######The script must be written in one line for each DDL #########
--###### Otherwise, hibernate can not run the script correctly ######
--###################################################################
-- MySQL Schema Script
-- MySQL Server 5.6.31
-- MySQL Workbench (6.3.7 CE) Forward Engineering
-- -----------------------------------------------------
-- Schema test
-- Tables starting with TL_ can be easily indentified as my application tables
-- in DB if there are other applications in the same DB.

-- -----------------------------------------------------
-- Table TL_TESTS_MESSAGE
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS TL_TEST_MESSAGE (
  id INT NOT NULL,
  message VARCHAR(120) NOT NULL,
  CONSTRAINT tl_test_message_pk PRIMARY KEY (id)
);

-- -----------------------------------------------------
-- Table TL_USERS
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS TL_USERS (
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
  CONSTRAINT tl_users_pk PRIMARY KEY (id),
  INDEX tl_users_index_acct_createtime (account, createdatetime)
);

-- CREATE INDEX tl_users_account_createdatetime on TL_USERS(account, createdatetime); -- For searching by username
-- DROP INDEX tl_users_account_createdatetime on TL_USERS;

-- -----------------------------------------------------
-- Table TL_GROUPS
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS TL_GROUPS (
  id INT NOT NULL,
  name VARCHAR(45) NULL,
  active BOOLEAN NULL,
  createdatetime DATETIME NULL,
  updatedatetime DATETIME NULL,
  CONSTRAINT tl_groups_pk PRIMARY KEY (id));

-- -----------------------------------------------------
-- Table TL_GROUP_MEMBERS
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS TL_GROUP_MEMBERS (
  id INT NOT NULL,
  groups_id INT NULL,
  users_id INT NULL,
  active BOOLEAN NULL,
  createdatetime DATETIME NULL,
  updatedatetime DATETIME NULL,
  CONSTRAINT tl_group_members_pk PRIMARY KEY (id),
  CONSTRAINT tl_group_members_fk_groupid FOREIGN KEY (groups_id) REFERENCES TL_GROUPS (id),
  CONSTRAINT tl_group_members_fk_userid FOREIGN KEY (users_id) REFERENCES TL_USERS (id));

-- -----------------------------------------------------
-- Table TL_PERMISSIONS
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS TL_PERMISSIONS (
  id INT NOT NULL,
  rolename VARCHAR(45) NULL,
  active BOOLEAN NULL,
  createdatetime DATETIME NULL,
  updatedatetime DATETIME NULL,
  CONSTRAINT tl_permissions_pk PRIMARY KEY (id));

-- -----------------------------------------------------
-- Table TL_GROUP_PERMISSIONS
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS TL_GROUP_PERMISSIONS (
  id INT NOT NULL,
  groups_id INT NULL,
  permissions_id INT NULL,
  active BOOLEAN NULL,
  createdatetime DATETIME NULL,
  updatedatetime DATETIME NULL,
  CONSTRAINT tl_group_permissions_pk PRIMARY KEY (id),
  CONSTRAINT tl_group_permissions_fk_groups_id FOREIGN KEY (groups_id) REFERENCES TL_GROUPS (id),
  CONSTRAINT tl_group_permissions_fk_permissions_id FOREIGN KEY (permissions_id) REFERENCES TL_PERMISSIONS (id));

-- -----------------------------------------------------
-- Table TL_TWITTERS
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS TL_TWITTERS (
  id INT NOT NULL,
  users_id INT NOT NULL,
  text_content VARCHAR(140) NULL,
  deleteflag BOOLEAN NULL,
  createdatetime DATETIME NULL,
  updatedatetime DATETIME NULL,
  PRIMARY KEY (id),
  INDEX TL_TWITTERS_users_id_fk_idx (users_id ASC),-- For searching twitters by username and createdatetime
  CONSTRAINT TL_TWITTERS_users_id_fk FOREIGN KEY (users_id) REFERENCES TL_USERS (id));


-- -----------------------------------------------------
-- Table TL_USERS_CONNECTIONS
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS TL_USERS_CONNECTIONS (
  id BIGINT NOT NULL,
  users_id_followee INT NOT NULL,
  users_id_followers INT NOT NULL,
  createdatetime DATETIME NULL,
  updatedatetime DATETIME NULL,
  PRIMARY KEY (id),
  INDEX TL_USERS_CONNECTIONS_users_id_fk_idx (users_id_followee ASC),
  INDEX TL_USERS_CONNECTIONS_followees_id_fk_idx (users_id_followers ASC),
  CONSTRAINT TL_USERS_CONNECTIONS_users_id_fk
    FOREIGN KEY (users_id_followee)
    REFERENCES TL_USERS (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT TL_USERS_CONNECTIONS_followers_id_fk
    FOREIGN KEY (users_id_followers)
    REFERENCES TL_USERS (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table TL_TWITTERS_FAVORITES
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS TL_TWITTERS_FAVORITES (
  id INT NOT NULL,
  twitters_id INT NULL,
  users_id INT NULL,
  createdatetime DATETIME NULL,
  updatedatetime DATETIME NULL,
  INDEX TL_TWITTERS_FAVORITES_twitters_id_fk_idx (twitters_id ASC),
  INDEX TL_TWITTERS_FAVORITES_users_id_fk_idx (users_id ASC),
  CONSTRAINT TL_TWITTERS_FAVORITES_twitters_id_fk
    FOREIGN KEY (twitters_id)
    REFERENCES TL_TWITTERS (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT TL_TWITTERS_FAVORITES_users_id_fk
    FOREIGN KEY (users_id)
    REFERENCES TL_USERS (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;