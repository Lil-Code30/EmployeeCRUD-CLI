
-- Department
CREATE TABLE IF NOT EXISTS departments (
department_id SERIAL PRIMARY KEY,
department_name VARCHAR(100) NOT NULL UNIQUE,
location VARCHAR(100)
);

-- Position 
CREATE TABLE IF NOT EXISTS titles (
title_id SERIAL PRIMARY KEY,
title_name VARCHAR(100) NOT NULL UNIQUE,
description TEXT
);


-- Employee 
CREATE TABLE IF NOT EXISTS employees (
employee_id SERIAL PRIMARY KEY,
first_name VARCHAR(50) NOT NULL,
last_name VARCHAR(50) NOT NULL,
email VARCHAR(100) UNIQUE NOT NULL,
phone VARCHAR(25),
hire_date DATE NOT NULL,
salary DECIMAL(10, 2) CHECK(salary >= 0),
title_id INT,
department_id INT,
manager_id INT REFERENCES employees(employee_id) ON DELETE SET NULL,
status VARCHAR(20) DEFAULT 'Active' CHECK(status IN ('Active', 'Inactive', 'On Leave')),
created_at TIMESTAMP DEFAULT NOW(),
updated_at TIMESTAMP DEFAULT NOW(),

FOREIGN KEY(title_id) REFERENCES titles(title_id),
FOREIGN KEY(department_id) REFERENCES departments(department_id)
);
