DELETE FROM modules;
DELETE FROM courses;

ALTER SEQUENCE global_seq RESTART WITH 1;

INSERT INTO courses (name, startDate, endDate) VALUES ('JAVA.Basics', '07-Oct-2015', '10-Feb-2016');
INSERT INTO courses (name, startDate, endDate) VALUES ('DotNet for beginners', '07-Oct-2015', '20-Mar-2016');

INSERT INTO modules (course_id, name, isEnabled, passed, passingScore) VALUES (1,'Introducing', true, false, 50);
INSERT INTO modules (course_id, name, isEnabled, passed, passingScore) VALUES (1, 'Objects and classes',true, false, 95);
INSERT INTO modules (course_id, name, isEnabled, passed, passingScore) VALUES (1, 'Inheritance', false, false, 75);
INSERT INTO modules (course_id, name, isEnabled, passed, passingScore) VALUES (1, 'Interfaces and nested classes', false, false, 75);
INSERT INTO modules (course_id, name, isEnabled, passed, passingScore) VALUES (1, 'Generics', false, false, 75);
INSERT INTO modules (course_id, name, isEnabled, passed, passingScore) VALUES (2, 'Introducing to .Net',true, false, 50);
INSERT INTO modules (course_id, name, isEnabled, passed, passingScore) VALUES (2, 'Collections', false, false, 75);

