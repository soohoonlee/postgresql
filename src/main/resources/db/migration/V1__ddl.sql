create table course
(
    id         uuid not null,
    name       varchar(255),
    rate       int2 not null,
    workload   int4 not null,
    teacher_id uuid,
    primary key (id)
);

create table teacher
(
    id         uuid not null,
    email      varchar(255),
    name       varchar(255),
    pictureurl varchar(255),
    primary key (id)
);

alter table course add constraint fk_course_teacher foreign key (teacher_id) references teacher;