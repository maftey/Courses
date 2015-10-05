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
  description VARCHAR(300)
);

CREATE TABLE modules (
  id         INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  course_id  INTEGER NOT NULL,
  name       VARCHAR (50) NOT NULL,
  startdate DATE NOT NULL,
  enddate  	DATE NOT NULL, 
  description VARCHAR(300),
  isenabled	 BOOLEAN,
  FOREIGN KEY (course_id) REFERENCES courses (id) ON DELETE CASCADE
);

CREATE TABLE tests
(
  id        INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  course_id  INTEGER NOT NULL,
  module_id  INTEGER NOT NULL,
  name      VARCHAR (50) NOT NULL,
  startdate DATE NOT NULL,
  enddate  	DATE NOT NULL, 
  isenabled BOOLEAN DEFAULT TRUE,
  passedscore INTEGER 
  FOREIGN KEY (course_id) REFERENCES courses (id) ON DELETE CASCADE
  FOREIGN KEY (module_id) REFERENCES modules (id) ON DELETE CASCADE
);

CREATE TABLE lessons
(
  id         INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  module_id  INTEGER NOT NULL,
  name       VARCHAR (50) NOT NULL,
  startdate DATE NOT NULL,
  enddate  	DATE NOT NULL, 
  description VARCHAR(300),
  isenabled	 BOOLEAN,
  text VARCHAR (10000)
  FOREIGN KEY (module_id) REFERENCES modules (id) ON DELETE CASCADE
);

CREATE TABLE questions 
(
  id        INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  test_id	INTEGER NOT NULL,
  name      VARCHAR (50) NOT NULL,
  text VARCHAR (10000),
  score INTEGER,
  FOREIGN KEY (test_id) REFERENCES tests (id) ON DELETE CASCADE
  );

