DELETE FROM lessons;
DELETE FROM questions;
DELETE FROM tests;
DELETE FROM modules;
DELETE FROM courses;


ALTER SEQUENCE global_seq RESTART WITH 1;

INSERT INTO courses (name, startdate, enddate, isenabled, description ) VALUES ('JAVA.Basics', '07-Oct-2015', '10-Feb-2016',true, 'Basic knowledge about Java Core');
INSERT INTO courses (name, startDate, endDate, isenabled, description) VALUES ('DotNet for beginners', '07-Oct-2015', '20-Mar-2016', true, 'Basic knowledge about Dot Net');

INSERT INTO tests (name, startdate, enddate, isenabled, passedscore) VALUES ('Introducing','10-Feb-2016', '10-Feb-2016', true, 50);
INSERT INTO tests (name, startdate, enddate, isenabled, passedscore) VALUES ('Objects and classes','14-Oct-2015', '14-Oct-2015', true, 75);
INSERT INTO tests (name, startdate, enddate, isenabled, passedscore) VALUES ('Inheritance','18-Oct-2015', '18-Oct-2015', true, 75);
INSERT INTO tests (name, startdate, enddate, isenabled, passedscore) VALUES ('Interfaces and nested classes','24-Oct-2015', '24-Oct-2015', true, 75);
INSERT INTO tests (name, startdate, enddate, isenabled, passedscore) VALUES ('Generics','30-Oct-2015', '30-Oct-2015', true, 75);
INSERT INTO tests (name, startdate, enddate, isenabled, passedscore) VALUES ('Introducing to .Net', '10-Oct-2015', '10-Oct-2015', true, 50);
INSERT INTO tests (name, startdate, enddate, isenabled, passedscore) VALUES ('Collections', '14-Oct-2015', '14-Oct-2015', true, 75);



INSERT INTO modules (name, startdate, enddate, description, isenabled, course_id) VALUES ('Introducing','07-Oct-2015', '10-Oct-2015', 'decription may be here',true, 1);
INSERT INTO modules (name, startdate, enddate, description, isenabled, course_id) VALUES ('Objects and classes','11-Oct-2015', '14-Oct-2015', 'decription may be here',true, 1);
INSERT INTO modules (name, startdate, enddate, description, isenabled, course_id) VALUES ('Inheritance','15-Oct-2015', '18-Oct-2015', 'decription may be here',true, 1);
INSERT INTO modules (name, startdate, enddate, description, isenabled, course_id) VALUES ('Interfaces and nested classes','21-Oct-2015', '24-Oct-2015', 'decription may be here',true, 1);
INSERT INTO modules (name, startdate, enddate, description, isenabled, course_id) VALUES ('Generics','27-Oct-2015', '30-Oct-2015', 'decription may be here',true, 1);
INSERT INTO modules (name, startdate, enddate, description, isenabled, course_id) VALUES ('Introducing to .Net', '07-Oct-2015', '10-Oct-2015', 'decription may be here',true, 2);
INSERT INTO modules (name, startdate, enddate, description, isenabled, course_id) VALUES ('Collections', '11-Oct-2015', '14-Oct-2015','decription may be here',true, 2);

INSERT INTO questions (text, score, test_id) VALUES ('some request obout subject',50, 3);
INSERT INTO questions (text, score, test_id) VALUES ('some request obout subject',50, 4);
INSERT INTO questions (text, score, test_id) VALUES ('some request obout subject',50, 5);
INSERT INTO questions (text, score, test_id) VALUES ('some request obout subject',50, 6);
INSERT INTO questions (text, score, test_id) VALUES ('some request obout subject',50, 7);
INSERT INTO questions (text, score, test_id) VALUES ('some request obout subject',50, 8);
INSERT INTO questions (text, score, test_id) VALUES ('some request obout subject',50, 9);

INSERT INTO lessons (name, startdate, enddate, description, isenabled, text, module_id) VALUES ('lesson 1','08-Oct-2015', '9-Oct-2015', 'decription may be here', true,  'text of lesson', 10);
INSERT INTO lessons (name, startdate, enddate, description, isenabled, text, module_id) VALUES ('lesson 2','12-Oct-2015', '13-Oct-2015', 'decription may be here',true,  'text of lesson', 11);
INSERT INTO lessons (name, startdate, enddate, description, isenabled, text, module_id) VALUES ('lesson 3','16-Oct-2015', '17-Oct-2015', 'decription may be here',true,  'text of lesson', 12);
INSERT INTO lessons (name, startdate, enddate, description, isenabled, text, module_id) VALUES ('lesson 4','22-Oct-2015', '23-Oct-2015', 'decription may be here',true,  'text of lesson', 13);
INSERT INTO lessons (name, startdate, enddate, description, isenabled, text, module_id) VALUES ('lesson 5','28-Oct-2015', '29-Oct-2015', 'decription may be here',true,  'text of lesson', 14);
INSERT INTO lessons (name, startdate, enddate, description, isenabled, text, module_id) VALUES ('lesson 6','08-Oct-2015', '09-Oct-2015', 'decription may be here',true,  'text of lesson', 15);
INSERT INTO lessons (name, startdate, enddate, description, isenabled, text, module_id) VALUES ('lesson 7','12-Oct-2015', '14-Oct-2015', 'decription may be here',true,  'text of lesson', 16);
INSERT INTO lessons (name, startdate, enddate, description, isenabled, text, module_id) VALUES ('lesson 8','21-Oct-2015', '22-Oct-2015', 'decription may be here',true,  'text of lesson', 10);
INSERT INTO lessons (name, startdate, enddate, description, isenabled, text, module_id) VALUES ('lesson 9','10-Oct-2015', '11-Oct-2015', 'decription may be here',true,  'text of lesson', 11);
INSERT INTO lessons (name, startdate, enddate, description, isenabled, text, module_id) VALUES ('lesson 10','27-Oct-2015', '28-Oct-2015', 'decription may be here',true,  'text of lesson', 12);


