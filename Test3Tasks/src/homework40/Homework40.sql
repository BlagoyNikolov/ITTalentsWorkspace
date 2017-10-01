# 1 Write a SQL query to display all information about all departments
SELECT * FROM departments;

# 2 Write a SQL query to find all department names
SELECT department_name FROM departments;

#3 Write a SQL query to find the salary of each employee by month, by day and hour. Consider that one month has 20 workdays and each workday has 8 work hours
SELECT salary AS 'month', salary/20 AS 'day', salary/160 AS 'hour'  
FROM employees;

# 4 Write a SQL query to find the email addresses of each employee. Consider that the mail domain is mail.somecompany.com. 
#Emails should look like "bernst@mail.somecompany.com". The produced column should be named "Full Email Address".
SELECT CONCAT(email, '@mail.somecompany.com') AS full_email_address FROM employees;

# 5 Write a SQL query to find all different salaries that are paid to the employees. Use DISTINCT.
SELECT DISTINCT salary FROM employees ORDER BY salary ASC;

# 6 Write a SQL query to find all departments and all region names, country names and city names as a single list. Use UNION
SELECT department_name AS single_list FROM departments 
UNION 
SELECT region_name FROM regions 
UNION 
SELECT country_name FROM countries 
UNION 
SELECT city FROM locations;

# 7 Write a SQL query to find all information about the employees whose position is "AC_MGR" (Accounting Manager)
SELECT * FROM employees WHERE job_id = 'AC_MGR';

# 8 Write a SQL query to find the names of all employees whose first name starts with "Sa". Use LIKE.
SELECT * FROM employees WHERE first_name LIKE 'SA%';

# 9 Write a SQL query to find the names of all employees whose last name contains the character sequence "ei". Use LIKE.
SELECT * FROM employees WHERE last_name LIKE '%ei%';

# 10 Write a SQL query to find the names of all employees whose salary is in the range [3000...5000]. Use BETWEEN.
SELECT first_name, last_name, salary FROM employees WHERE salary BETWEEN 3000 AND 5000 ORDER BY salary ASC;

# 11 Write a SQL query to find the names of all employees whose salary is in the range [2000...15000] but is not in range [5000 … 10000]. Use MINUS
SELECT first_name, last_name, salary FROM employees WHERE salary BETWEEN 2000 AND 15000 
AND salary NOT IN 
(SELECT salary FROM employees WHERE salary BETWEEN 5000 AND 10000); 

# 12 Write a SQL query to find the names of all employees whose salary is 2500, 4000 or 5000. Use IN
SELECT first_name, last_name, salary FROM employees WHERE salary IN (2500, 4000, 5000);

# 13 Write a SQL query to find all locations that have no state or post code defined. Use IS NULL
SELECT * FROM locations WHERE state_province IS NULL OR postal_code IS NULL;

# 14 Write a SQL query to find all employees that are paid more than 10 000. Order them in decreasing order by salary. Use ORDER BY
SELECT first_name, last_name, salary FROM employees WHERE salary > 10000 ORDER BY salary DESC;

# 15 Write a SQL query to find the first 10 employees joined the company (most senior people)
SELECT first_name, last_name, hire_date FROM employees ORDER BY hire_date ASC LIMIT 10;

# 16 Write a SQL query to find all departments and the town of their location. Use NATURAL JOIN
SELECT department_name, city FROM departments NATURAL JOIN locations;

# 17 Write a SQL query to find all departments and the town of their location. Use join with USING clause
SELECT department_name, city FROM departments JOIN locations USING (location_id);

# 18 Write a SQL query to find all departments and the town of their location. Use inner join with ON clause
SELECT department_name, city FROM departments INNER JOIN locations ON departments.location_id = locations.location_id;

# 19 Modify the last SQL query to include also the name of the manager for each department
SELECT department_name, city, manager_id FROM departments INNER JOIN locations ON departments.location_id = locations.location_id;

# 20 Write a SQL query to find all the locations and the departments for each location along with the locations that do not have department. User right outer join
SELECT department_name, city FROM departments right outer join locations ON departments.location_id = locations.location_id;

# 21 Rewrite the last SQL query to use left outer join
SELECT department_name, city FROM departments left outer join locations ON departments.location_id = locations.location_id;

# 22 Rewrite the last query to use WHERE instead of JOIN
SELECT department_name, location_id FROM departments 
WHERE location_id in
(SELECT location_id FROM locations WHERE location_id = departments.location_id);

# 23 Write a SQL query to find the manager name of each department
SELECT department_name, first_name FROM departments JOIN employees ON departments.manager_id = employees.employee_id;

# 24 Modify the last SQL query to find also the location of each department manager
SELECT department_name, first_name, city FROM departments 
JOIN employees ON departments.manager_id = employees.employee_id 
JOIN locations ON departments.location_id = locations.location_id;

# 25 Write a SQL query to find the names of all employees from the departments "Sales" and "Finance" whose hire year is between 1995 and 2000
SELECT first_name, last_name, department_name 
FROM employees 
JOIN departments ON employees.department_id = departments.department_id 
AND departments.department_name IN ('Sales', 'Finance') 
AND employees.hire_date > STR_TO_DATE('1/1/1999', '%m/%d/%Y');

# 26 Find all employees that have worked in the past in the department “Sales”. Use complex join condition
SELECT first_name FROM employees 
JOIN job_history ON employees.employee_id = job_history.employee_id 
AND job_history.end_date IS NOT NULL
AND job_history.department_id = 80;


# 27 Write a SQL query to display all employees (first and last name) along with their corresponding manager (first and last name). Use self-join
SELECT e.first_name, e.last_name, m.first_name, m.last_name
FROM employees e
INNER JOIN employees m
ON e.employee_id = m.manager_id;

# 28 Combine all first names with all last names of the employees with a CROSS JOIN
SELECT e.first_name, e.last_name
FROM employees e CROSS JOIN employees;

# 29 Write a SQL query to display all employees, along with their job title, department, location, country and region. Use multiple joins
SELECT first_name, last_name, job_title, department_name, city, country_name, region_name
FROM employees
JOIN jobs ON employees.job_id = jobs.job_id 
JOIN departments ON employees.department_id = departments.department_id
JOIN locations ON departments.location_id = locations.location_id
JOIN countries ON locations.country_id = countries.country_id
JOIN regions ON countries.region_id = regions.region_id;

# 30 Modify the last SQL query to display also the manager name for each employee or “No manager” in case there is no manager.
SELECT e.first_name, e.last_name, m.first_name, m.last_name, job_title, department_name, city, country_name, region_name
FROM employees e
JOIN employees m ON m.employee_id = e.manager_id 
JOIN jobs ON e.job_id = jobs.job_id 
JOIN departments ON e.department_id = departments.department_id
JOIN locations ON departments.location_id = locations.location_id
JOIN countries ON locations.country_id = countries.country_id
JOIN regions ON countries.region_id = regions.region_id;

# 31 Write a SQL querry to find all employees that have worked in the past at job position “AC_ACCOUNT” and at some time later at job position “AC_MGR”. Display the employees’ names and current job title.
# Hint: first self-join JOB_HISTORY table, then apply filtering and finally join the result with EMPLOYEES and JOBS tables.