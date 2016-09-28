-- MySQL Workbench Forward Engineering

-- -----------------------------------------------------
-- Schema test
-- -----------------------------------------------------

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
  cellphone VARCHAR(45) NOT NULL,
  active BOOLEAN NULL,
  createdatetime DATETIME NOT NULL,
  updatedatetime DATETIME NULL,
  PRIMARY KEY (id)); 

CREATE INDEX tl_users_account_createdatetime on TL_USERS(account, createdatetime); -- For searching by username
--DROP INDEX tl_users_account_createdatetime on TL_USERS;


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
  INDEX users_id_idx (users_id ASC),-- For searching twitters by username and createdatetime
  CONSTRAINT tl_twitters_fk FOREIGN KEY (users_id) REFERENCES TL_USERS (id));


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
  INDEX users_id_fk_idx (users_id_followee ASC),
  INDEX followees_id_fk_idx (users_id_followers ASC),
  CONSTRAINT users_id_fk
    FOREIGN KEY (users_id_followee)
    REFERENCES TL_USERS (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT followers_id_fk
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
  INDEX twitters_id_fk_idx (twitters_id ASC),
  INDEX users_id_fk_idx (users_id ASC),
  CONSTRAINT twitters_id_fk
    FOREIGN KEY (twitters_id)
    REFERENCES TL_TWITTERS (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT users_id_fk
    FOREIGN KEY (users_id)
    REFERENCES TL_USERS (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table TL_GROUPS
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS TL_GROUPS (
  id INT NOT NULL,
  name VARCHAR(45) NULL,
  active BOOLEAN NULL,
  createdatetime DATETIME NULL,
  updatedatetime DATETIME NULL,
  PRIMARY KEY (id))
ENGINE = InnoDB;


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
  PRIMARY KEY (id),
  INDEX groups_id_idx (groups_id ASC),
  INDEX users_id_idx (users_id ASC),
  CONSTRAINT groups_id
    FOREIGN KEY (groups_id)
    REFERENCES TL_GROUPS (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT users_id
    FOREIGN KEY (users_id)
    REFERENCES TL_USERS (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table TL_PERMISSIONS
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS TL_PERMISSIONS (
  id INT NOT NULL,
  rolename VARCHAR(45) NULL,
  active BOOLEAN NULL,
  createdatetime DATETIME NULL,
  updatedatetime DATETIME NULL,
  PRIMARY KEY (id))
ENGINE = InnoDB;


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
  PRIMARY KEY (id),
  INDEX permissions_id_idx (permissions_id ASC),
  INDEX groups_id_idx (groups_id ASC),
  CONSTRAINT groups_id
    FOREIGN KEY (groups_id)
    REFERENCES TL_GROUPS (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT permissions_id
    FOREIGN KEY (permissions_id)
    REFERENCES TL_PERMISSIONS (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
