-- Departamentos
INSERT INTO department (department_name, department_status) VALUES ('Sistemas', 'A');
INSERT INTO department (department_name, department_status) VALUES ('Contabilidad', 'A');
INSERT INTO department (department_name, department_status) VALUES ('RRHH', 'I');
INSERT INTO department (department_name, department_status) VALUES ('People', 'A');

-- Empleados
INSERT INTO employee (employee_name, employee_last_name, age, salary, init_date, end_date, employee_status, department_id) VALUES
('Luis', 'Pérez', 22, 500, '2021-02-10', null, 'A', 1),
('Maria', 'Gonzalez', 25, 600, '2020-03-11', null, 'A', 1),
('Pedro', 'Gómez', 30, 700, '2020-03-11', '2024-05-20', 'I', 2),
('José', 'López', 20, 550, '2020-03-11', null, 'A', 2);

