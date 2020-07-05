CREATE DATABASE list_students;

create table students(
    studentID varchar(6) primary key,
    name varchar(20),
    address varchar(50),
    phone int
)