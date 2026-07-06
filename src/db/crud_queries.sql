
SELECT * FROM employees;

SELECT * FROM employees WHERE employee_id = 89;

INSERT INTO employees (first_name, last_name, email, phone, hire_date, salary)
VALUES 
('John', 'Doe', 'john.doe@email.com', '514-123-4567', '2024-01-10', 55000),
('Sarah', 'Martin', 'sarah.martin@email.com', '438-222-8899', '2023-11-05', 62000),
('David', 'Nguyen', 'david.nguyen@email.com', '450-777-1020', '2022-06-18', 72000),
('Emma', 'Brown', 'emma.brown@email.com', '514-888-3344', '2025-03-22', 48000),
('Michael', 'Johnson', 'michael.johnson@email.com', '438-999-5566', '2021-09-14', 80000);

SELECT * FROM employees WHERE first_name LIKE  '%loko%' OR last_name LIKE '%loko%';

SELECT * FROM employees ORDER BY salary;

SELECT * FROM employees ORDER BY hire_date;

SELECT * FROM employees WHERE salary >= 60000;

--- department

SELECT * FROM departments;

INSERT INTO departments (department_name, location)
VALUES
('Human Resources', 'New York'),
('Information Technology', 'San Francisco'),
('Finance', 'Chicago'),
('Marketing', 'Los Angeles'),
('Sales', 'Dallas'),
('Research and Development', 'Boston'),
('Customer Support', 'Toronto'),
('Operations', 'Seattle'),
('Legal', 'Washington D.C.'),
('Procurement', 'Miami');

--- CRUD 

SELECT * FROM departments WHERE department_name LIKE '%Human Resources%';

DELETE INTO departments WHERE department_id = 2;

SELECT e.first_name, e.last_name, e.email, e.salary, d.* FROM employees e
INNER JOIN departments d
ON e.department_id = d.department_id;

SELECT e.first_name, e.last_name, e.email, e.salary, d.* FROM employees e
INNER JOIN departments d
ON e.department_id = d.department_id WHERE d.department_name = 'Finance';
