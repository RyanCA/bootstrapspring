
--------------------------------------------------------
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
drop table if exists TL_USERS_CONNECTIONS;
drop table if exists TL_TWITTERS_FAVORITES;
drop table if exists TL_TWITTERS;

-- Security tables
drop table if exists TL_GROUP_MEMBERS;
drop table if exists TL_GROUP_PERMISSIONS;
drop table if exists TL_PERMISSIONS;
drop table if exists TL_GROUPS;
drop table if exists TL_USERS;
-- -----------------------------------------------------
