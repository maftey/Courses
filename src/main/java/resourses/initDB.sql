DROP TABLE IF EXISTS modules;
DROP TABLE IF EXISTS courses;
DROP SEQUENCE IF EXISTS global_seq;

--CREATE OR REPLACE FUNCTION f_create_db(dbname courses)
--  RETURNS integer AS
--BEGIN
--IF EXISTS (SELECT 1 FROM pg_database WHERE datname = dbname) THEN
--   RAISE NOTICE 'Database already exists'; 
--ELSE
--   PERFORM dblink_exec('dbname=' || current_database()
--                     , 'CREATE DATABASE ' || quote_ident(dbname));
--END IF;
--
--END
-- LANGUAGE plpgsql;


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