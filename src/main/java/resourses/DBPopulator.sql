DELETE FROM lessons;
DELETE FROM questions;
DELETE FROM tests;
DELETE FROM modules;
DELETE FROM courses;


ALTER SEQUENCE global_seq RESTART WITH 1;

INSERT INTO courses (name, startdate, enddate, isenabled, description ) VALUES ('JAVA.Basics', '07-Oct-2015', '10-Feb-2016',true, 'Basic knowledge about Java Core');
INSERT INTO courses (name, startDate, endDate, isenabled, description) VALUES ('DotNet for beginners', '07-Oct-2015', '20-Mar-2016', true, 'Basic knowledge about Dot Net');

INSERT INTO modules (name, startdate, enddate, description, isenabled, course_id) VALUES ('Introducing','07-Oct-2015', '10-Oct-2015', 'decription may be here',true, 1);
INSERT INTO modules (name, startdate, enddate, description, isenabled, course_id) VALUES ('Objects and classes','11-Oct-2015', '14-Oct-2015', 'decription may be here',true, 1);
INSERT INTO modules (name, startdate, enddate, description, isenabled, course_id) VALUES ('Inheritance','15-Oct-2015', '18-Oct-2015', 'decription may be here',true, 1);
INSERT INTO modules (name, startdate, enddate, description, isenabled, course_id) VALUES ('Interfaces and nested classes','21-Oct-2015', '24-Oct-2015', 'decription may be here',true, 1);
INSERT INTO modules (name, startdate, enddate, description, isenabled, course_id) VALUES ('Generics','27-Oct-2015', '30-Oct-2015', 'decription may be here',true, 1);
INSERT INTO modules (name, startdate, enddate, description, isenabled, course_id) VALUES ('Introducing to .Net', '07-Oct-2015', '10-Oct-2015', 'decription may be here',true, 2);
INSERT INTO modules (name, startdate, enddate, description, isenabled, course_id) VALUES ('Collections', '11-Oct-2015', '14-Oct-2015','decription may be here',true, 2);

INSERT INTO tests (name, startdate, enddate, isenabled, passedscore, course_id, module_id) VALUES ('Introducing','10-Feb-2016', '10-Feb-2016', true, 50, 1,NULL);
INSERT INTO tests (name, startdate, enddate, isenabled, passedscore, course_id, module_id) VALUES ('Objects and classes','14-Oct-2015', '14-Oct-2015', true, 75, 1,3);
INSERT INTO tests (name, startdate, enddate, isenabled, passedscore, course_id, module_id) VALUES ('Inheritance','18-Oct-2015', '18-Oct-2015', true, 75, 1,4);
INSERT INTO tests (name, startdate, enddate, isenabled, passedscore, course_id, module_id) VALUES ('Interfaces and nested classes','24-Oct-2015', '24-Oct-2015', true, 75, 1, 5);
INSERT INTO tests (name, startdate, enddate, isenabled, passedscore, course_id, module_id) VALUES ('Generics','30-Oct-2015', '30-Oct-2015', true, 75, 1,6);
INSERT INTO tests (name, startdate, enddate, isenabled, passedscore, course_id, module_id) VALUES ('Introducing to .Net', '10-Oct-2015', '10-Oct-2015', true, 50, 2,7);
INSERT INTO tests (name, startdate, enddate, isenabled, passedscore, course_id, module_id) VALUES ('Collections', '14-Oct-2015', '14-Oct-2015', true, 75, 2,3);

INSERT INTO questions (name, text, score, test_id) VALUES ('test question', 'some request obout subject',50, 16);
INSERT INTO questions (name, text, score, test_id) VALUES ('test question', 'some request obout subject',50, 15);
INSERT INTO questions (name, text, score, test_id) VALUES ('test question', 'some request obout subject',50, 14);
INSERT INTO questions (name, text, score, test_id) VALUES ('test question', 'some request obout subject',50, 13);
INSERT INTO questions (name, text, score, test_id) VALUES ('test question', 'some request obout subject',50, 12);
INSERT INTO questions (name, text, score, test_id) VALUES ('test question', 'some request obout subject',50, 11);
INSERT INTO questions (name, text, score, test_id) VALUES ('test question', 'some request obout subject',50, 10);

INSERT INTO lessons (name, startdate, enddate, description, isenabled, text, module_id) VALUES ('lesson 1','08-Oct-2015', '9-Oct-2015', 'decription may be here', true,  'text of lesson', 8);
INSERT INTO lessons (name, startdate, enddate, description, isenabled, text, module_id) VALUES ('lesson 2','12-Oct-2015', '13-Oct-2015', 'decription may be here',true,  'text of lesson', 9);
INSERT INTO lessons (name, startdate, enddate, description, isenabled, text, module_id) VALUES ('lesson 3','16-Oct-2015', '17-Oct-2015', 'decription may be here',true,  'text of lesson', 3);
INSERT INTO lessons (name, startdate, enddate, description, isenabled, text, module_id) VALUES ('lesson 4','22-Oct-2015', '23-Oct-2015', 'decription may be here',true,  'text of lesson', 4);
INSERT INTO lessons (name, startdate, enddate, description, isenabled, text, module_id) VALUES ('lesson 5','28-Oct-2015', '29-Oct-2015', 'decription may be here',true,  'text of lesson', 4);
INSERT INTO lessons (name, startdate, enddate, description, isenabled, text, module_id) VALUES ('lesson 6','08-Oct-2015', '09-Oct-2015', 'decription may be here',true,  'text of lesson', 5);
INSERT INTO lessons (name, startdate, enddate, description, isenabled, text, module_id) VALUES ('lesson 7','12-Oct-2015', '14-Oct-2015', 'decription may be here',true,  'text of lesson', 6);
INSERT INTO lessons (name, startdate, enddate, description, isenabled, text, module_id) VALUES ('lesson 8','21-Oct-2015', '22-Oct-2015', 'decription may be here',true,  'text of lesson', 7);
INSERT INTO lessons (name, startdate, enddate, description, isenabled, text, module_id) VALUES ('lesson 9','10-Oct-2015', '11-Oct-2015', 'decription may be here',true,  'text of lesson', 8);
INSERT INTO lessons (name, startdate, enddate, description, isenabled, text, module_id) VALUES ('lesson 10','27-Oct-2015', '28-Oct-2015', 'decription may be here',true,  'text of lesson', 7);


