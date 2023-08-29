-- Drop database if exists and create a new one
DROP DATABASE IF EXISTS heinote;
CREATE DATABASE heinote;

\c heinote ;

CREATE TABLE "group" (
    id SERIAL PRIMARY KEY,
    name VARCHAR(4) NOT NULL UNIQUE
);
ALTER SEQUENCE "group_id_seq" RESTART WITH 1 ;


CREATE TABLE student (
    id SERIAL PRIMARY KEY ,
    last_name VARCHAR(100) ,
    first_name VARCHAR(100) ,
    student_number VARCHAR(20) ,
    group_id INT REFERENCES "group" ON DELETE CASCADE   
);

ALTER SEQUENCE "student_id_seq" RESTART WITH 1 ;

CREATE TABLE subject (
    id SERIAL PRIMARY KEY ,
    subject_code VARCHAR(10)  CHECK (subject_code IN ('PROG1', 'PROG2' ,'WEB1' , 'WEB2' , 'DONNEE1' ,'LV1' ,'SYS1' ,'SYS2' ,'IA1' ,'THEORIE1' )),
    coef_subject INT NOT NULL 
);

ALTER SEQUENCE "subject_id_seq" RESTART WITH 1 ;

CREATE TABLE note (
    id SERIAL PRIMARY KEY ,
    subject_id INT REFERENCES subject(id),
    student_id INT REFERENCES student(id),
    note FLOAT NOT NULL
) ;

ALTER SEQUENCE "note_id_seq" RESTART WITH 1 ;