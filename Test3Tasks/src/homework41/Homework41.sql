# 1	Write a SQL query to find the average salary in the "Sales" department. Use AVG().
SELECT AVG(salary) FROM employees WHERE department_id = 80;
SELECT AVG(salary) FROM employees JOIN departments ON employees.department_id = departments.department_id WHERE department_name = 'Sales';

# 2 Write a SQL query to find the number of employees in the "Sales" department. Use COUNT(*).
SELECT COUNT(*) FROM employees WHERE department_id = 80;
SELECT COUNT(*) FROM employees JOIN departments ON employees.department_id = departments.department_id WHERE department_name = 'Sales';

# 3 Write a SQL query to find the number of all locations where the company has an office.
SELECT COUNT(*) FROM departments JOIN locations ON departments.location_id = locations.location_id;

# 4 Write a SQL query to find the number of all departments that has manager.
SELECT COUNT(*) FROM departments WHERE manager_id IS NOT NULL;

# 5 Write a SQL query to find the number of all departments that has no manager.
SELECT COUNT(*) FROM departments WHERE manager_id IS NULL;

# 6	Write a SQL query to find all departments' names and the average salary for each of them.
SELECT department_name, AVG(salary) as avg_salary
FROM employees as e 
JOIN departments as d ON d.department_id = e.department_id 
GROUP BY e.department_id;

# 7	Write a SQL query to find the count of all employees in each department. Display the name, location and number of employees for each department.
SELECT department_name, city, COUNT(e.employee_id)
FROM employees AS e
JOIN departments ON e.department_id = departments.department_id
JOIN locations ON locations.location_id = departments.location_id
GROUP BY e.department_id;

#??? 8	Write a SQL query to find for each department and for each manager the count of all corresponding employees.
SELECT department_name, m.first_name, m.last_name, COUNT(e.employee_id) AS number_of_employees
FROM employees AS e JOIN employees AS m 
ON e.manager_id = m.employee_id
JOIN departments ON m.department_id = departments.department_id
GROUP BY m.department_id;

# 9	Write a SQL query to find all managers that have exactly 5 employees. Display their names and the name and location of their department.
SELECT department_name, m.first_name, m.last_name, COUNT(e.employee_id) AS number_of_employees
FROM employees AS e JOIN employees AS m 
ON e.manager_id = m.employee_id
JOIN departments ON m.department_id = departments.department_id
GROUP BY m.department_id
HAVING COUNT(e.employee_id) = 5;

# 10 Write a SQL query to find the total number of employees for each region.
SELECT r.region_name, COUNT(employee_id) AS number_of_employees
FROM employees 
JOIN departments
ON departments.department_id = employees.department_id
JOIN locations
ON locations.location_id = departments.location_id
JOIN countries
ON countries.country_id = locations.country_id
JOIN regions AS r
ON r.region_id = countries.region_id
GROUP BY r.region_id;

# 11 Write a SQL query to find for each department and for each job title the total number of employees.
SELECT department_name, COUNT(employee_id) AS number_of_employees
FROM departments
JOIN employees ON departments.department_id = employees.department_id
GROUP BY employees.department_id;

SELECT job_title, COUNT(employee_id) AS number_of_employees
FROM jobs
JOIN employees ON jobs.job_id = employees.job_id
GROUP BY jobs.job_id;

SELECT department_name, job_title, COUNT(employee_id) AS number_of_employees
FROM departments
JOIN employees AS e ON departments.department_id = e.department_id
JOIN jobs ON jobs.job_id = e.job_id
GROUP BY e.department_id, jobs.job_id;

# 12 Write a SQL query to find the names and salaries of the employees that take the minimal salary in the company. Use nested SELECT statement.
SELECT first_name, last_name, salary
FROM employees
WHERE salary = 
(SELECT MIN(salary) FROM employees);

# 13 Write a SQL query to find the names and salaries of the employees that get a salary that is up to 10% higher than the minimal salary for the company.
SELECT first_name, last_name, salary
FROM employees
WHERE salary <
1.1 * (SELECT MIN(salary) FROM employees);

# 14 Write a SQL query that displays all departments and the highest salary for each department along with the name of the employee that takes it. 
# If multiple employees in the same department have highest salary, display the first of them.
SELECT department_name, salary, first_name, last_name
FROM departments d
JOIN employees ON employees.department_id = d.department_id
WHERE salary =
(SELECT MAX(salary) from departments)
GROUP BY d.department_id;

# 15 Write a SQL query to find the names of all employees whose last name is exactly 5 characters long.
SELECT first_name, last_name
FROM employees
WHERE CHAR_LENGTH(last_name) = 5;

# 16 Write a SQL query to find the names of all employees whose first name and last name start with the same letter. 
SELECT first_name, last_name
FROM employees
WHERE LEFT(first_name, 1) = LEFT(last_name, 1);

# 17 Display all departments names and their manager's name. For departments without manager display "(No manager)". 
SELECT department_name, COALESCE(first_name, 'N/A') AS first_name, COALESCE(last_name, 'N/A') AS last_name 
FROM departments AS d 
LEFT JOIN employees AS e 
ON d.department_id = e.department_id 
GROUP BY d.department_id;

# 18 Display all employees along with their number of directly managed people. 
# For employees not managing anybody display "Just an employee". For employees managing only 1 employee display "Junior manager". 
SELECT m.first_name, m.last_name, COUNT(e.employee_id),
CASE
WHEN COUNT(e.employee_id) = 0 THEN 'Just an employee'
WHEN COUNT(e.employee_id) = 1 THEN 'Junior manager'
WHEN COUNT(e.employee_id) > 1 THEN CONVERT(COUNT(e.employee_id) USING utf8)
END 
AS number_of_managed_people
FROM employees AS e 
RIGHT JOIN employees AS m 
ON e.manager_id = m.employee_id
GROUP BY e.manager_id;

# 19 Write a SQL query to print the current date and time in the format " hour:minutes:seconds day-month-year". Display also the date coming after a week
SELECT DATE_FORMAT(NOW(), "%H:%i:%s %d-%m-%Y") AS currenttime;
SELECT DATE_FORMAT(NOW() + INTERVAL 1 WEEK, "%H:%i:%s %d-%m-%Y") AS time_in_a_week;

# 20 Write a SQL statement to create a table USERS. 
# Users should have username, password, full name and last login time. 
# Choose appropriate data types for the fields of the table. 
# Define a primary key column with a primary key constraint.  
# Define a trigger to automatically fill the full name column value before inserting a record.
CREATE TABLE USERS (
	user_id INTEGER NOT NULL AUTO_INCREMENT,
    username NVARCHAR(50) NOT NULL,
	password NVARCHAR(50) NOT NULL,
    last_login DATETIME,
    CONSTRAINT user_pk PRIMARY KEY(user_id)
);

DROP TABLE USERS;

# 21 Write a SQL statement to create a view that displays the users from the USERS table that have been in the system today. 
# Test if the view works correctly.
CREATE VIEW logged_today AS
SELECT * FROM users WHERE last_login = CURDATE();

SELECT * FROM logged_today;

INSERT INTO users (username, password, last_login)
VALUES ('TOTKA', '123', CURDATE());

# 22 Write a SQL statement to create a table GROUPS. Groups should have unique name (use unique constraint). 
CREATE TABLE GROUPS (
	group_id INTEGER NOT NULL AUTO_INCREMENT,
    name NVARCHAR(50) UNIQUE NOT NULL,
    CONSTRAINT group_pk PRIMARY KEY(group_id)
);

# 23 Write a SQL statement to add a column GROUP_ID to the table USERS. 
# Fill some data in this new column and as well in the GROUPS table. 
# Write a SQL statement to add a foreign key constraint between tables USERS and GROUPS
ALTER TABLE users
ADD (group_id INTEGER);

INSERT INTO users (username, password, last_login, group_id)
VALUES ('LUCHO', '123', CURDATE(), 1);

INSERT INTO groups (name)
VALUES ('Family');

ALTER TABLE users
ADD constraint group_id_fk
foreign key (group_id)
references groups(group_id);

# 24 Write SQL statements to insert several records in the USERS and GROUPS tables
INSERT INTO groups (name)
VALUES ('Friends');

INSERT INTO users (username, password, last_login, group_id)
VALUES ('DESO', '123', CURDATE(), 2);

INSERT INTO groups (name)
VALUES ('Colleagues');

INSERT INTO users (username, password, last_login, group_id)
VALUES ('VESI', '123', CURDATE(), 3);

INSERT INTO groups (name)
VALUES ('Employees');

INSERT INTO users (username, password, last_login, group_id)
VALUES ('VESI', '123', CURDATE(), 3);

SELECT first_name, last_name, salary FROM hr.employees WHERE last_name = 'King' AND salary > 10 AND salary < 1000000;
SELECT country_id, country_name FROM countriesjava;

# 25 Write SQL statements to insert in the USERS table the names of all employees from the employees table. 
# Combine the first and last names as a full name. For user name use the email column from employees. Use blank password
ALTER TABLE users
ADD (full_name NVARCHAR(50)); 

INSERT INTO users (username, password, last_login, full_name)
SELECT email, '<blank password>', NOW(), CONCAT(first_name, ' ', last_name) 
FROM employees;

# 26 Run the above 10 times to generate enough testing data for the USERS table.
INSERT INTO users (username, password, last_login, full_name)
SELECT email, '<blank password>', NOW() + INTERVAL 1 YEAR, CONCAT(first_name, ' ', last_name) 
FROM employees;

# 27 Write a SQL statement that changes the password to NULL for all USERS that have not been in the system since 10.03.2006. Select table data to see the changes. 
SET SQL_SAFE_UPDATES = 0;
ALTER TABLE users MODIFY password VARCHAR(50);
UPDATE users SET password = NULL WHERE last_login <= '2018-10-01';

# 28 Write a SQL statement that deletes all users without passwords (NULL or empty password). Select table data to see the changes. 
DELETE FROM users WHERE password IS NULL OR password = '<blank password>';

# 29 Write a SQL query to list all users whose username starts with 's' and the number of groups for each of them. 
SELECT username, full_name
FROM users WHERE username LIKE 'S%';

# 30 Define table WORKHOURS to store work reports for each employee (date, task, hours, comments).
CREATE TABLE WORKHOURS (
	hours_id INTEGER NOT NULL AUTO_INCREMENT,
	date DATETIME,
    task NVARCHAR(50),
    hours INT,
    comments NVARCHAR(50),
    CONSTRAINT hours_pk PRIMARY KEY(hours_id)
);

# 31 Define foreign key between the tables WORKHOURS and EMPLOYEE. Add additional column in the employee table if needed.
ALTER TABLE employees ADD hours_id INT;

ALTER TABLE employees
ADD CONSTRAINT hours_id_fk
FOREIGN KEY (hours_id)
REFERENCES workhours(hours_id);

# 32 Write several SQL statements to fill some data in the WORKHOURS table.
INSERT INTO workhours (date, task, hours, comments)
VALUES (NOW(), 'youtube', 5, 'youtube');

# 33 Write a SQL query to find all the average work hours per week for each country.
SELECT AVG(hours) as avg_hours, city, country_name
FROM employees 
JOIN workhours
ON employees.hours_id = workhours.hours_id
JOIN departments
ON departments.department_id = employees.department_id
JOIN locations
ON departments.location_id = locations.location_id
JOIN countries
ON locations.country_id = countries.country_id
GROUP BY countries.country_id;

# 34 Write a SQL query to find all the departments where some employee worked overtime (over 8 hours/day) during the last week.
SELECT AVG(hours) as avg_hours, city, country_name
FROM employees 
JOIN workhours
ON employees.hours_id = workhours.hours_id
JOIN departments
ON departments.department_id = employees.department_id
JOIN locations
ON departments.location_id = locations.location_id
JOIN countries
ON locations.country_id = countries.country_id
GROUP BY countries.country_id
HAVING avg_hours > 8;

# 35 Write a SQL query to find all employees that have worked 3 or more days overtime in the last week. Display their name, location department and country.
SELECT first_name, last_name, (hours) as avg_hours, city, country_name
FROM employees 
JOIN workhours
ON employees.hours_id = workhours.hours_id
JOIN departments
ON departments.department_id = employees.department_id
JOIN locations
ON departments.location_id = locations.location_id
JOIN countries
ON locations.country_id = countries.country_id
GROUP BY countries.country_id
HAVING avg_hours > 8 AND COUNT(hours) = 3;

SELECT e.first_name, e.last_name, m.first_name AS manager_first_name, m.last_name AS manager_last_name, department_name
FROM employees AS e
JOIN employees AS m
ON m.employee_id = e.manager_id
JOIN departments
ON departments.department_id = e.department_id;

SELECT first_name, last_name, salary as avg_salary 
FROM hr.employees 
JOIN hr.departments 
ON employees.department_id = departments.department_id 
WHERE department_name = 'Purchasing';

SELECT user_id, user_name, group_name 
FROM hr.usersjava 
JOIN groupsjava 
ON usersjava.group_id = groupsjava.group_id 
WHERE group_name = 'Colleagues';