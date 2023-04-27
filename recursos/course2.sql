DROP SCHEMA IF EXISTS course;
CREATE SCHEMA course;
USE course;

CREATE TABLE teacher (
	id INT NOT NULL AUTO_INCREMENT,
    teacher VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE course (
	course VARCHAR(255) NOT NULL,
    hours INT,
    classroom VARCHAR(255),
    vacations VARCHAR(255),
    teacher_id INT NOT NULL,
    PRIMARY KEY (course),
    FOREIGN KEY (teacher_id) REFERENCES teacher(id)
);

INSERT INTO teacher (teacher) VALUES
('Alberto García'),
('Beatriz López'),
('Carmen Martín');

INSERT INTO course (course, hours, classroom, vacations, teacher_id) VALUES
('Math', 100, 'A1', '2 weeks', 1),
('Programming', 150, 'B1', '3 weeks', 2),
('Computer science', 150, 'B1', '3 weeks', 2),
('English', 90, 'A2', '1 week', 1),
('Physics', 200, 'C1', '3 weeks', 1),
('Chemistry', 120, 'Lab1', '2 weeks', 3);







CREATE TABLE exam (
	id VARCHAR(255) NOT NULL,
    start_date DATE,
    mandatory BOOL,
    PRIMARY KEY (id)
);

CREATE TABLE multiple_choice_exam (
	id VARCHAR(255) NOT NULL,
    number_of_choices INT,
    FOREIGN KEY (id) REFERENCES exam(id)
);

CREATE TABLE free_response_exam (
	id VARCHAR(255) NOT NULL,
    FOREIGN KEY (id) REFERENCES exam(id)
);





CREATE TABLE student (
	id INT NOT NULL AUTO_INCREMENT,
    grade INT,
    street VARCHAR(255),
    house_number INT,
    telephone VARCHAR(255),
    PRIMARY KEY (id)    
);







-- SELECT * FROM teacher; 
-- SELECT * FROM course;

-- SELECT * FROM course ORDER BY hours;
-- SELECT * FROM course ORDER BY hours DESC;
-- SELECT * FROM course ORDER BY hours DESC LIMIT 2;

-- SELECT course, hours FROM course;
-- SELECT course, hours FROM course WHERE hours >= 100 AND hours <= 200;
-- SELECT course, hours FROM course WHERE hours BETWEEN 100 AND 200;

-- SELECT * FROM course WHERE classroom = 'B1';
-- SELECT * FROM course WHERE classroom LIKE '_1';
-- SELECT * FROM course WHERE classroom LIKE '%1';
-- SELECT * FROM course WHERE course LIKE '%p%';

-- SELECT classroom FROM course;
-- SELECT COUNT(classroom) AS classrooms FROM course;
-- SELECT DISTINCT classroom FROM course;
-- SELECT COUNT(DISTINCT classroom) AS different_classrooms FROM course;

-- SELECT SUM(hours) AS total_hours FROM course;
-- SELECT SUM(hours) AS total_hours FROM course WHERE teacher_id = 1;

-- SELECT AVG(hours) AS avg_hours FROM course;

-- SELECT MAX(hours) AS max_hours, MIN(hours) AS min_hours FROM course;

-- SELECT teacher_id, SUM(hours) AS total_hours FROM course GROUP BY teacher_id;
-- SELECT teacher_id, SUM(hours) AS total_hours FROM course GROUP BY teacher_id HAVING total_hours > 200;

-- SELECT *
-- FROM course c
-- JOIN teacher t ON c.teacher_id = t.id;

-- SELECT c.course, c.hours, c.classroom, t.teacher
-- FROM course c
-- JOIN teacher t ON c.teacher_id = t.id;

-- -- SELECT c.course, c.hours, c.classroom, t.teacher
-- -- FROM course c
-- -- INNER JOIN teacher t ON c.teacher_id = t.id;

-- -- SELECT c.course, c.hours, c.classroom, t.teacher
-- -- FROM course c
-- -- LEFT JOIN teacher t ON c.teacher_id = t.id;

-- SELECT c.course, c.hours, c.classroom, t.teacher
-- FROM course c
-- JOIN teacher t ON c.teacher_id = t.id
-- WHERE c.hours > 100;

-- SELECT t.teacher, SUM(c.hours) AS total_hours
-- FROM course c
-- JOIN teacher t ON c.teacher_id = t.id
-- GROUP BY t.teacher;