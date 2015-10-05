DROP TABLE IF EXISTS modules;
DROP TABLE IF EXISTS courses;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START 1;

CREATE TABLE courses
(
  id        INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name      VARCHAR NOT NULL,
  startDate DATE NOT NULL,
  endDate  	DATE NOT NULL 
);

CREATE TABLE modules (
  id         INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  course_id  INTEGER NOT NULL,
  name       VARCHAR NOT NULL,
  isEnabled	 BOOLEAN,
  passed	 BOOLEAN,
  passingScore INTEGER,
  FOREIGN KEY (course_id) REFERENCES courses (id) ON DELETE CASCADE
);