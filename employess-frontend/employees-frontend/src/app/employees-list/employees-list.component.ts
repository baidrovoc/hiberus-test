import { Component } from '@angular/core';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-employees-list',
  standalone: false,
  templateUrl: './employees-list.component.html',
})
export class EmployeesListComponent {
  employees: Employee[];

  constructor(private employeeService: EmployeeService){}

  ngOnInit(){
    this.getEmployees();
  }

  private getEmployees(){
    this.employeeService.getEmployeeList().subscribe
    (datos => {this.employees=datos;});
  }
}
