CREATE TABLE t_course ( 
   id INT NOT NULL, 
   course_name VARCHAR(50) NOT NULL, 
   code VARCHAR(20) NOT NULL, 
   credit int
);
INSERT INTO t_course (id, course_name,code,credit) VALUES (399, 'Introduction to Java','CS103',6);
INSERT INTO t_course (id, course_name,code,credit) VALUES (199, 'OO Programming with Java','CS105',6);
INSERT INTO t_course (id, course_name,code,credit) VALUES (299, 'Java Spring Backend','CS393',4);