BEGIN TRANSACTION;

DROP TABLE IF EXISTS department, employee, project, project_employee, timesheet CASCADE;

CREATE TABLE department (
	department_id serial,
	name varchar(40) UNIQUE NOT NULL,
	CONSTRAINT PK_department PRIMARY KEY (department_id)
);

CREATE TABLE employee (
	employee_id serial,
	department_id int,
	first_name varchar(20) NOT NULL,
	last_name varchar(30) NOT NULL,
	birth_date date NOT NULL,
	hire_date date NOT NULL,
	CONSTRAINT PK_employee PRIMARY KEY (employee_id),
	CONSTRAINT FK_employee_department FOREIGN KEY (department_id) REFERENCES department(department_id)
);

CREATE TABLE project (
	project_id serial,
	name varchar(40) UNIQUE NOT NULL,
	from_date date,
	to_date date,
	CONSTRAINT PK_project PRIMARY KEY (project_id)
);

CREATE TABLE project_employee (
	project_id int NOT NULL,
	employee_id int NOT NULL,
	CONSTRAINT PK_project_employee PRIMARY KEY (project_id, employee_id),
	CONSTRAINT FK_project_employee_project FOREIGN KEY (project_id) REFERENCES project(project_id),
	CONSTRAINT FK_project_employee_employee FOREIGN KEY (employee_id) REFERENCES employee(employee_id)
);

CREATE TABLE timesheet (
    timesheet_id serial,
    employee_id int NOT NULL,
    project_id int NOT NULL,
    date_worked date NOT NULL,
    hours_worked numeric(5,2) NOT NULL,
    billable boolean NOT NULL,
    description varchar(100),
    CONSTRAINT PK_timesheet PRIMARY KEY (timesheet_id),
    CONSTRAINT FK_timesheet_employee FOREIGN KEY (employee_id) REFERENCES employee(employee_id),
    CONSTRAINT FK_timesheet_project FOREIGN KEY (project_id) REFERENCES project(project_id)
);

-- Need a department so we can add employees
INSERT INTO department (name)
VALUES ('Department 1'); -- department_id will be 1 due to serial

-- Need employees so we can add timesheets
INSERT INTO employee (department_id, first_name, last_name, birth_date, hire_date)
VALUES (1, 'First1', 'Last1', '1981-01-01', '2001-01-02'), -- employee_id will be 1 due to serial
       (1, 'First2', 'Last2', '1982-02-01', '2002-02-03'); -- employee_id will be 2 due to serial

-- Need projects so we can add timesheets
INSERT INTO project (name, from_date, to_date)
VALUES ('Project 1', '2000-01-02', '2000-12-31'), -- project_id will be 1 due to serial
       ('Project 2', NULL, NULL);                 -- project_id will be 2 due to serial

INSERT INTO timesheet (employee_id, project_id, date_worked, hours_worked, billable, description)
VALUES (1, 1, '2021-01-01', 1.0, true, 'Timesheet 1'),  -- timesheet_id will be 1 due to serial
       (1, 1, '2021-01-02', 1.5, true, 'Timesheet 2'),  -- timesheet_id will be 2 due to serial
       (2, 1, '2021-01-01', 0.25, true, 'Timesheet 3'), -- timesheet_id will be 3 due to serial
       (2, 2, '2021-02-01', 2.0, false, 'Timesheet 4'); -- timesheet_id will be 4 due to serial

COMMIT;