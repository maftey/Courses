DROP TABLE IF EXISTS questions;
DROP TABLE IF EXISTS lessons;
DROP TABLE IF EXISTS tests;
DROP TABLE IF EXISTS modules;
DROP TABLE IF EXISTS courses;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START 1;

CREATE TABLE courses
(
  id        INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name      VARCHAR (50) NOT NULL,
  startdate DATE NOT NULL,
  enddate  	DATE NOT NULL, 
  isenabled BOOLEAN DEFAULT TRUE,
  description VARCHAR(300),
  test_id	INTEGER
);

CREATE TABLE modules (
  id         INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
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
  id        INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name      VARCHAR (50) NOT NULL,
  startdate DATE NOT NULL,
  enddate  	DATE NOT NULL, 
  isenabled BOOLEAN DEFAULT TRUE,
  passedscore INTEGER
);

CREATE TABLE lessons
(
  id         INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name       VARCHAR (50) NOT NULL,
  startdate DATE NOT NULL,
  enddate  	DATE NOT NULL, 
  description VARCHAR(300),
  isenabled	 BOOLEAN DEFAULT TRUE,
  text VARCHAR (10000),
  module_id  INTEGER NOT NULL,
  tes_id	INTEGER,
  FOREIGN KEY (module_id) REFERENCES modules (id) ON DELETE CASCADE
);

CREATE TABLE questions 
(
  id        INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  text VARCHAR (10000),
  score INTEGER,
  test_id	INTEGER NOT NULL,
  FOREIGN KEY (test_id) REFERENCES tests (id) ON DELETE CASCADE
  );