DROP TABLE users IF EXISTS;
DROP TABLE persons IF EXISTS;

CREATE TABLE users (
  id   INT AUTO_INCREMENT PRIMARY KEY ,
  name VARCHAR(30),
  password VARCHAR(50),
  email  VARCHAR(50),
  imageSrc VARCHAR(250)
);

CREATE TABLE persons (
  id   INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(50),
  gender VARCHAR(1)
);