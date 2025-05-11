# Sistema de Gestión de Empleados y Departamentos

Este proyecto es una aplicación de backend construida con **Spring Boot** y **base de datos H2** en memoria, que permite gestionar empleados y departamentos dentro de una compañía.

## 📄 Tecnologías Utilizadas

* Java 21
* Spring Boot 3.2.5
* Spring Web
* Spring Data JPA
* H2 Database
* Maven
* Lombok
* JUnit 5 y Mockito (para pruebas)

---

## ⚙️ Ejecución del Proyecto

### 1. Clonar el repositorio:

```bash
git clone <url-del-repositorio>
```

### 2. Ejecutar el proyecto desde tu IDE o consola:

```bash
mvn clean install
mvn spring-boot:run
```

### 3. Acceso a la consola H2:

```
http://localhost:8080/h2-console
JDBC URL: jdbc:h2:mem:testdb
```

---

## 🔍 Endpoints Disponibles

### DepartmentController:

* `POST /department/create` – Crea un nuevo departamento
* `POST /department/delete/{departmentId}` – Eliminación lógica de un departamento

### EmployeeController:

* `POST /employee/create/{departmentId}` – Crea un nuevo empleado asociado a un departamento
* `POST /employee/delete/{employeeId}` – Eliminación lógica del empleado
* `GET /employee/highestSalary` – Devuelve empleado con salario más alto
* `GET /employee/lowerAge` – Devuelve el empleado más joven
* `GET /employee/countLastMonth` – Número de empleados ingresados en el último mes

---

## 📊 Estructura del Proyecto

```
com.example.employees
├── controller
│   ├── DepartmentController.java
│   └── EmployeeController.java
├── entity
│   ├── Department.java
│   └── Employee.java
├── repository
│   ├── DepartmentRepository.java
│   └── EmployeeRepository.java
├── services
│   ├── DepartmentService.java
│   └── EmployeeService.java
├── test
│   ├── DepartmentControllerTest.java
│   └── EmployeeControllerTest.java
└── EmployeesApplication.java
```

---

## 🔧 Consideraciones Técnicas

* Se usan **Streams** en operaciones de filtrado (salario, edad, fechas).
* Se planea el uso de **DTOs** para separar la entidad de la capa de API (en proceso).
* Se implementa **eliminación lógica** mediante cambio de estado (Activo/Inactivo).
* Los datos iniciales se cargan desde `data.sql` al iniciar la app.

---

## ✅ Estado Actual

* [x] Endpoints funcionales
* [x] Datos precargados
* [x] Pruebas unitarias implementadas
* [x] Uso de DTOs 
* [x] La aplicación se encuentra dockerizada

---

## 🚀 Autor

**\[Byron Idrovo]**
