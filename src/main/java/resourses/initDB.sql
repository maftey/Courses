DROP TABLE IF EXISTS questions;
DROP TABLE IF EXISTS lessons;
DROP TABLE IF EXISTS tests;
DROP TABLE IF EXISTS modules;
DROP TABLE IF EXISTS courses;
DROP SEQUENCE IF EXISTS courses_seq;
DROP SEQUENCE IF EXISTS modules_seq;
DROP SEQUENCE IF EXISTS tests_seq;
DROP SEQUENCE IF EXISTS questions_seq;
DROP SEQUENCE IF EXISTS lessons_seq;

CREATE SEQUENCE courses_seq START 1;
CREATE SEQUENCE modules_seq START 1;
CREATE SEQUENCE tests_seq START 1;
CREATE SEQUENCE questions_seq START 1;
CREATE SEQUENCE lessons_seq START 1;

CREATE TABLE courses
(
  id       INTEGER PRIMARY KEY DEFAULT nextval('courses_seq'),
  name      VARCHAR (50) NOT NULL,
  startdate DATE NOT NULL,
  enddate  	DATE NOT NULL, 
  isenabled BOOLEAN DEFAULT TRUE,
  description VARCHAR(300),
  test_id	INTEGER
);

CREATE TABLE modules 
(
  id        INTEGER PRIMARY KEY DEFAULT nextval('modules_seq'),
  name       VARCHAR (50) NOT NULL,
  startdate DATE NOT NULL,
  enddate  	DATE NOT NULL, 
  description VARCHAR(300),
  isenabled	 BOOLEAN DEFAULT TRUE,
  course_id  INTEGER NOT NULL,
  test_id	INTEGER,
  FOREIGN KEY (course_id) REFERENCES courses (id) ON DELETE CASCADE
  
);

CREATE TABLE tests
(
  id        INTEGER PRIMARY KEY DEFAULT nextval('tests_seq'),
  name      VARCHAR (50) NOT NULL,
  startdate DATE NOT NULL,
  enddate  	DATE NOT NULL, 
  isenabled BOOLEAN DEFAULT TRUE,
  passedscore INTEGER
);

CREATE TABLE questions 
(
  id        INTEGER PRIMARY KEY DEFAULT nextval('questions_seq'),
  text 		VARCHAR (10000),
  score 	INTEGER,
  test_id	INTEGER NOT NULL,
  FOREIGN KEY (test_id) REFERENCES tests (id) ON DELETE CASCADE
  );
  
CREATE TABLE lessons
(
  id         INTEGER PRIMARY KEY DEFAULT nextval('lessons_seq'),
  name       VARCHAR (50) NOT NULL,
  startdate DATE NOT NULL,
  enddate  	DATE NOT NULL, 
  description VARCHAR(300),
  isenabled	 BOOLEAN DEFAULT TRUE,
  text VARCHAR (10000),
  module_id  INTEGER NOT NULL,
  test_id	INTEGER,
  FOREIGN KEY (module_id) REFERENCES modules (id) ON DELETE CASCADE
);

