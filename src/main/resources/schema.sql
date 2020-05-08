create table if not exists student (
	id identity,
	jmbag varchar(10) not null unique,
	first_name varchar(100) not null,
	last_name varchar(100) not null,
	ects_points number not null,
	date_of_birth date not null
);

create table if not exists course (
	id identity,
	name varchar(100) not null,
	ects_points number not null
);

create table if not exists student_course (
    id identity,
    student_id bigint,
    course_id bigint,
    constraint fk_student foreign key (student_id) references student(id),
    constraint fk_course foreign key (course_id) references course(id)
)
