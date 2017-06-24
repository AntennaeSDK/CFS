
-- Create userids
GRANT ALL PRIVILEGES ON *.* TO 'cfs'@'localhost' IDENTIFIED BY 'cfs123';
GRANT ALL PRIVILEGES ON *.* TO 'cfs'@'*' IDENTIFIED BY 'cfs123';

-- Create Database
CREATE DATABASE CFS;


-- create table
CREATE TABLE USERS {
    ID
}
