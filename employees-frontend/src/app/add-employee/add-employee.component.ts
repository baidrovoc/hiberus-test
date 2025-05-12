import { Component, OnInit } from '@angular/core';
import { Router }  from '@angular/router';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';
import { DepartmentService } from '../department.service';

@Component({
  selector: 'app-add-employee',
  standalone: false,
  templateUrl: './add-employee.component.html',
  
})
export class AddEmployeeComponent implements OnInit {
employee: Employee = new Employee();
departments: any[] = [];

  constructor(private employeeService: EmployeeService,
     private departmentService: DepartmentService,
    private enrutador: Router){}

ngOnInit(): void {
    this.loadDepartments();
  }

  loadDepartments(): void {
    this.departmentService.getDepartments().subscribe({
      next: (data) => this.departments = data,
      error: (err) => console.error('Error al cargar departamentos:', err)
    });
  }
  onSubmit(){
    this.addEmployee();
  }

  addEmployee(){
    this.employeeService.addEmployee(this.employee).subscribe(
      {
        next: (datos) => {
          
        },
        error: (error: any) => {console.log(error)}
      }
    );
  }
}
